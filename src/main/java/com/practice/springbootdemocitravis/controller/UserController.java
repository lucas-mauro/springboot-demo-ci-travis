package com.practice.springbootdemocitravis.controller;

import com.practice.springbootdemocitravis.entity.User;
import com.practice.springbootdemocitravis.entity.UserRequest;
import com.practice.springbootdemocitravis.entity.UserResponse;
import com.practice.springbootdemocitravis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User addUser(@RequestBody UserRequest userRequest){

        return userService.addNewUser(userRequest.toEntity());
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserResponse>> getAllUsers(){

        return ResponseEntity.ok(userService.getAllUsers()
                .stream().map(UserResponse::new).collect(Collectors.toList()));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {

        return ResponseEntity.ok(new UserResponse(userService.getById(id)));
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id,
                                                   @RequestBody UserRequest userRequest) {

        return ResponseEntity.ok(new UserResponse(
                userService.updateUser(id,userRequest.toEntity())));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return ResponseEntity.ok().build();
    }

}
