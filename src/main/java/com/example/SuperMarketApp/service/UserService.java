package com.example.SuperMarketApp.service;

import com.example.SuperMarketApp.dao.UserDao;
import com.example.SuperMarketApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User registerNewUser(User user){
        return userDao.save(user);


    }
}
