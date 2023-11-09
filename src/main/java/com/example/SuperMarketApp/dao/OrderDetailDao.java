package com.example.SuperMarketApp.dao;

import com.example.SuperMarketApp.entity.OrderDetail;
import org.springframework.data.repository.CrudRepository;


public interface OrderDetailDao extends CrudRepository<OrderDetail,Integer> {
}
