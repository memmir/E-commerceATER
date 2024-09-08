package com.ater.commerce.user.service;

import com.ater.commerce.user.dto.CreateUserRequest;
import com.ater.commerce.user.dto.UpdateUserRequest;
import com.ater.commerce.user.dto.UserDto;
import com.ater.commerce.user.dto.UserDtoConverter;
import com.ater.commerce.user.exception.UserNotFoundException;
import com.ater.commerce.user.model.User;
import com.ater.commerce.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public List<UserDto> getAllUsers(){
        return userRepository.findAll().stream().map(x -> userDtoConverter.convert(x)).collect(Collectors.toList());
    }

    public UserDto getUserById(Long id){
        User user = findUserById(id);

        return userDtoConverter.convert(user);
    }

    public UserDto createUser(CreateUserRequest createUserRequest){
        User user = new User(null,
                createUserRequest.getMail(),
                createUserRequest.getFirstName(),
                createUserRequest.getLastName(),
                createUserRequest.getMiddleName());

        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto updateUser(Long id, UpdateUserRequest updateUserRequest){
        User user = findUserById(id);
        User updateUser = new User(user.getId(),
                user.getMail(),
                updateUserRequest.getFirstName(),
                updateUserRequest.getLastName(),
                updateUserRequest.getMiddleName());

        return userDtoConverter.convert(userRepository.save(updateUser));
    }

    private User findUserById(Long id){
        return userRepository.findById(id).orElseThrow( () -> new UserNotFoundException("User could not be found by id:" + id));
    }
}
