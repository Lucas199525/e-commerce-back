package com.ArcomTech.ApiV1.controller;

import com.ArcomTech.ApiV1.model.User;
import com.ArcomTech.ApiV1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.fetchAllUser();
    }

    @GetMapping("/user/{id}")
   public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
   }
}
