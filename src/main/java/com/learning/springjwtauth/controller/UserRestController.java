package com.learning.springjwtauth.controller;

import com.learning.springjwtauth.model.User;
import com.learning.springjwtauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/signup")
    public ResponseEntity<String> handleUserRegistration(@RequestBody User user){

        Objects.requireNonNull(user.getUsername(), "user name can not be null");
        Objects.requireNonNull(user.getPassword(), "user password can not be null");
        Objects.requireNonNull(user.getRoles(), "roles can not be null");

        String username = userService.registerUser(user).getUsername();

        return new ResponseEntity<>("This user ' " + username + "' has been registered successfully", HttpStatus.OK);
    }

}
