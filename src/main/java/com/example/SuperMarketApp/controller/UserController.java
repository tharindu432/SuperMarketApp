package com.example.SuperMarketApp.controller;

import com.example.SuperMarketApp.entity.User;
import com.example.SuperMarketApp.service.RoleService;
import com.example.SuperMarketApp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
    @Autowired
    private final UserService userService;

    @PostConstruct
   public void initRolesAndUser(){
    userService.initRolesAndUser();
   }
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping({"registerNewUser"})
    public User registerNewUser(@RequestBody User user){
      return   userService.registerNewUser(user);

    }

    @GetMapping({"/forAdmin"})
    public String forAdmin(){
        return "this url is only accssible to admin";
    }

    @GetMapping({"/forUser"})
    public String forUser(){
        return "this url is only accssible to users";
    }


}
