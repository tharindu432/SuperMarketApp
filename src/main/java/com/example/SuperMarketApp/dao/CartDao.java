package com.example.SuperMarketApp.dao;

import com.example.SuperMarketApp.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CartDao extends CrudRepository< Cart,Integer> {
}
