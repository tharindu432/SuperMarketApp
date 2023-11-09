package com.youtube.SuperMarketApp.dao;

import com.youtube.SuperMarketApp.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
