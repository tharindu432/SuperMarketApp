package com.example.SuperMarketApp.controller;

import com.example.SuperMarketApp.entity.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @PostMapping({"/addNewProduct"})
    public void addNewProduct(Product product){


    }
}
