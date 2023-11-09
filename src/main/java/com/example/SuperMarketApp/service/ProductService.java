package com.example.SuperMarketApp.service;


import com.example.SuperMarketApp.dao.ProductDao;
import com.example.SuperMarketApp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Product addNewProduct(Product product){
        return productDao.save(product);
    }
}
