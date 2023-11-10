package com.example.SuperMarketApp.dao;

import com.example.SuperMarketApp.entity.OrderDetail;
import com.example.SuperMarketApp.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface OrderDetailDao extends CrudRepository<OrderDetail,Integer> {
    public List<OrderDetail> findByUser(User user);
}
