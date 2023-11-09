package com.example.SuperMarketApp.controller;


import com.example.SuperMarketApp.entity.OrderInput;
import com.example.SuperMarketApp.service.OrderDetailService;
import com.example.SuperMarketApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailsController {
    @Autowired
    private OrderDetailService orderDetailService;

    @PreAuthorize("hasRole('User')")
    @PostMapping({"/placeOrder"})
    public void placeOrder(@RequestBody OrderInput orderInput){
         orderDetailService.placeOrder(orderInput);
    }
}
