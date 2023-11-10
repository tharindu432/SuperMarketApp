package com.example.SuperMarketApp.dao;

import com.example.SuperMarketApp.entity.Cart;
import com.example.SuperMarketApp.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface CartDao extends CrudRepository< Cart,Integer> {
    public List<Cart> findByUser(User user);
}
