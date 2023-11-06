package com.example.SuperMarketApp.controller;

import com.example.SuperMarketApp.entity.Role;
import com.example.SuperMarketApp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    private final RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @PostMapping({"/createNewRole"})
    public Role createNewRole( @RequestBody  Role role){
        return roleService.createNewRole(role);

    }
}
