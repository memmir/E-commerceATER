package com.ater.user.service;

import com.ater.user.dto.UserDto;
import com.ater.user.dto.UserDtoConverter;
import com.ater.user.repository.UserRepository;
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
}
