package com.example.SuperMarketApp.service;

import com.example.SuperMarketApp.dao.RoleDao;
import com.example.SuperMarketApp.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
