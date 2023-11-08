package com.example.SuperMarketApp.controller;

import com.example.SuperMarketApp.entity.Product;
import com.example.SuperMarketApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping({"/addNewProduct"})
    public Product addNewProduct(Product product){
       return productService.addNewProduct(product);


    }
}
