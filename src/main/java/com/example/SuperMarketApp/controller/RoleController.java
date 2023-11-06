package com.example.SuperMarketApp.controller;

import com.example.SuperMarketApp.entity.Role;
import com.example.SuperMarketApp.service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    private RoleService roleService;
    @PostMapping({"/createNewRole"})
    public Role createNewRole(Role role){
        return roleService.createNewRole(role);

    }
}
