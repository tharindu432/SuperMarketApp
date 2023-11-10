package com.example.SuperMarketApp.service;

import com.example.SuperMarketApp.configuration.JwtRequestFilter;
import com.example.SuperMarketApp.dao.CartDao;
import com.example.SuperMarketApp.dao.ProductDao;
import com.example.SuperMarketApp.dao.UserDao;
import com.example.SuperMarketApp.entity.Cart;
import com.example.SuperMarketApp.entity.Product;
import com.example.SuperMarketApp.entity.User;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    public Cart addToCart(Integer productId){
        Product product=productDao.findById(productId).get();
        String username= JwtRequestFilter.CURRENT_USER;
        User user=null;
        if(username != null){
            user=userDao.findById(username).get();
        }

        if(product !=null &&  user != null){
            Cart cart=new Cart(product,user);
           return cartDao.save(cart);


        }
        return null;
    }

    public List<Cart> getCartDetails(){
        String username=JwtRequestFilter.CURRENT_USER;
       User user= userDao.findById(username).get();
        return cartDao.findByUser(user);
    }
}