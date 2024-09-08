package com.ater.commerce.user.service;

import com.ater.commerce.user.dto.CreateUserRequest;
import com.ater.commerce.user.dto.UpdateUserRequest;
import com.ater.commerce.user.dto.UserDto;
import com.ater.commerce.user.dto.UserDtoConverter;
import com.ater.commerce.user.exception.UserNotFoundException;
import com.ater.commerce.user.model.UserInformation;
import com.ater.commerce.user.repository.UserInformationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserInformationRepository userInformationRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserInformationRepository userInformationRepository, UserDtoConverter userDtoConverter) {
        this.userInformationRepository = userInformationRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public List<UserDto> getAllUsers(){
        return userInformationRepository.findAll().stream().map(x -> userDtoConverter.convert(x)).collect(Collectors.toList());
    }

    public UserDto getUserByMail(String mail){
        UserInformation userInformation = findUserByMail(mail);

        return userDtoConverter.convert(userInformation);
    }

    public UserDto createUser(CreateUserRequest createUserRequest){
        UserInformation userInformation = new UserInformation(null,
                createUserRequest.getMail(),
                createUserRequest.getFirstName(),
                createUserRequest.getLastName(),
                createUserRequest.getMiddleName());

        return userDtoConverter.convert(userInformationRepository.save(userInformation));
    }

    public UserDto updateUser(String mail, UpdateUserRequest updateUserRequest){
        UserInformation userInformation = findUserByMail(mail);
        UserInformation updateUser = new UserInformation(userInformation.getId(),
                userInformation.getMail(),
                updateUserRequest.getFirstName(),
                updateUserRequest.getLastName(),
                updateUserRequest.getMiddleName());

        return userDtoConverter.convert(userInformationRepository.save(updateUser));
    }

    private UserInformation findUserById(Long id){
        return userInformationRepository.findById(id)
                .orElseThrow( () -> new UserNotFoundException("User could not be found by id:" + id));
    }

    private UserInformation findUserByMail(String mail){
        return userInformationRepository.findByMail(mail)
                .orElseThrow( () -> new UserNotFoundException("User could not be found by mail:" + mail));
    }


}
