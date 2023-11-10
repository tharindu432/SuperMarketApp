package com.example.SuperMarketApp.service;


import com.example.SuperMarketApp.dao.ProductDao;
import com.example.SuperMarketApp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.print.Pageable;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Product addNewProduct(Product product){
        return productDao.save(product);
    }

    public List<Product> getAllProducts(int pageNumber){
        Pageable pageable= (Pageable) PageRequest.of(pageNumber,10);
        return (List<Product>) productDao.findAll(pageable);
    }



    public Product getProductById(Integer productId){
      return   productDao.findById(productId).get();
    }

    public void deleteProductDetails(Integer productId){
        productDao.deleteById(productId);
    }
}
