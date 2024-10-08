package com.ater.commerce.user.controller;

import com.ater.commerce.user.dto.CreateUserRequest;
import com.ater.commerce.user.dto.UpdateUserRequest;
import com.ater.commerce.user.dto.UserDto;
import com.ater.commerce.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{mail}")
    public ResponseEntity<UserDto> getUserByMail(@PathVariable String mail) {
        return ResponseEntity.ok(userService.getUserByMail(mail));
    }

    @PostMapping // Post methodu response entity döneceği zaman 201 döner.
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest userRequest) {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @PutMapping("/{mail}") // Put methodu response entity döneceği zaman 202 döner.
    public ResponseEntity<UserDto> updateUser(
            @PathVariable String mail,
            @RequestBody UpdateUserRequest updateUserRequest){
        return ResponseEntity.ok(userService.updateUser(mail, updateUserRequest));
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<Void> deactiveUser(@PathVariable("id") Long id) {
//        userService.deactiveUser(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
//        userService.deleteUser(id);
//        return ResponseEntity.ok().build();
//    }




}
