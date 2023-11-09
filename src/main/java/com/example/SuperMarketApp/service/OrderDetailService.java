package com.example.SuperMarketApp.service;

import com.example.SuperMarketApp.configuration.JwtRequestFilter;
import com.example.SuperMarketApp.dao.OrderDetailDao;
import com.example.SuperMarketApp.dao.ProductDao;
import com.example.SuperMarketApp.dao.UserDao;
import com.example.SuperMarketApp.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    private static String ORDER_PLACED="placed";
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private ProductDao productDao;

    @Autowired

    private UserDao userDao;
    public  void placeOrder(OrderInput orderInput){
        List< OrderProductQuantity> productQuantityList=orderInput.getOrderProductQuantityList();
        for(OrderProductQuantity o: productQuantityList){
          Product product= productDao.findById(o.getProductId()).get();

            String currentUser=JwtRequestFilter.CURRENT_USER;
           User user= userDao.findById(currentUser).get();
            OrderDetail orderDetail=new OrderDetail(
                    orderInput.getFullName(),
                    orderInput.getFullAddress(),
                    orderInput.getContactNumber(),
                    orderInput.getAlternateContactNumber(),
                    ORDER_PLACED,
                    product.getProductActualPrice() * o.getQuantity(),
                    product,
                    user



            );
            orderDetailDao.save(orderDetail);
        }

    }
}
