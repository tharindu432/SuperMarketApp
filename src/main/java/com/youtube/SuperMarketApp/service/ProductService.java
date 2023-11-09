package com.youtube.SuperMarketApp.service;

import com.youtube.SuperMarketApp.dao.ProductDao;
import com.youtube.SuperMarketApp.entity.Product;
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
