package com.youtube.SuperMarketApp.service;

import com.youtube.SuperMarketApp.dao.RoleDao;
import com.youtube.SuperMarketApp.entity.Role;
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
