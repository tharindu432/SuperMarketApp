package com.example.SuperMarketApp.controller;


import com.example.SuperMarketApp.entity.OrderDetail;
import com.example.SuperMarketApp.entity.OrderInput;
import com.example.SuperMarketApp.service.OrderDetailService;
import com.example.SuperMarketApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailsController {
    @Autowired
    private OrderDetailService orderDetailService;

    @PreAuthorize("hasRole('User')")
    @PostMapping({"/placeOrder{isSingleProductCheckout}"})
    public void placeOrder(@PathVariable(name = "isSingleProductCheckout") boolean isSingleProductCheckout,
            @RequestBody OrderInput orderInput){
         orderDetailService.placeOrder(orderInput,isSingleProductCheckout);
    }

    @PreAuthorize("hasRole('User')")
    @GetMapping({"/getOrderDetails"})
    public List<OrderDetail> getOrderDetails(){
    return  orderDetailService.getOrderDetails();
    }


    @PreAuthorize("hasRole('Admin')")
    @GetMapping({"/getAllOrderDetails"})
    public List<OrderDetail> getAllOrderDetails(){
        return orderDetailService.getAllOrderDetails();

    }


    @GetMapping({"/markOrderAsDelivered/{orderId}"})
    public void markOrderAsDelivered(@PathVariable(name = "productId")Integer orderId){

        orderDetailService.markOrderAsDelivered(orderId);
    }
}
