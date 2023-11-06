package com.example.SuperMarketApp.controller;

import com.example.SuperMarketApp.entity.User;
import com.example.SuperMarketApp.service.RoleService;
import com.example.SuperMarketApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping({"registerNewUser"})
    public User registerNewUser(User user){
      return   userService.registerNewUser(user);

    }
}
