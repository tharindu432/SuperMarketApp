package com.example.SuperMarketApp.service;


import com.example.SuperMarketApp.configuration.JwtRequestFilter;
import com.example.SuperMarketApp.dao.CartDao;
import com.example.SuperMarketApp.dao.ProductDao;
import com.example.SuperMarketApp.dao.UserDao;
import com.example.SuperMarketApp.entity.Cart;
import com.example.SuperMarketApp.entity.Product;
import com.example.SuperMarketApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.*;
//import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;


    @Autowired
    private UserDao userDao;

    @Autowired
    private CartDao cartDao;

    public Product addNewProduct(Product product){
        return productDao.save(product);
    }

    public List<Product> getAllProducts(int pageNumber,String searchKey){
      Pageable pageable= (Pageable) PageRequest.of(pageNumber,10);
        if(searchKey.equals("")){
            return (List<Product>) productDao.findAll(pageable);
        }else {
           return(List<Product>) productDao.findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(
                    searchKey,searchKey,pageable
            );

        }

    }



    public Product getProductById(Integer productId){
      return   productDao.findById(productId).get();
    }
    
    



    public void deleteProductDetails(Integer productId){
        productDao.deleteById(productId);
    }

    public List<Product> getProductDetails(boolean isSingleProductCheckout, Integer productId) {
        if (isSingleProductCheckout && productId !=0) {
            //checkout a single product
            List<Product> productList = new ArrayList<>();
            Product product=productDao.findById(productId).get();
            productList.add(product);
           return productList;
        } else {
          //checkout the entire cart
           // return getAllProducts(0, ""); // Assuming 0 is the default pageNumber and empty searchKey
           String username= JwtRequestFilter.CURRENT_USER;
         User user= userDao.findById(username).get();
        List<Cart> carts= cartDao.findByUser(user);

        carts.stream().map(x -> x.getProduct()).collect(Collectors.toList());

        }
        return new ArrayList<>();
    }
}
