package com.example.SuperMarketApp.service;

import com.example.SuperMarketApp.configuration.JwtRequestFilter;
import com.example.SuperMarketApp.dao.CartDao;
import com.example.SuperMarketApp.dao.OrderDetailDao;
import com.example.SuperMarketApp.dao.ProductDao;
import com.example.SuperMarketApp.dao.UserDao;
import com.example.SuperMarketApp.entity.*;
import jdk.javadoc.internal.doclets.formats.html.PackageUseWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    CartDao cartDao;

    public List<OrderDetail>  getAllOrderDetails(){
        List<OrderDetail> orderDetails=new ArrayList<>();
        orderDetailDao.findAll().forEach(
                x -> orderDetails.add(x)
        );
        return orderDetails;
    }


    public List<OrderDetail> getOrderDetails(){
      String currentUser=  JwtRequestFilter.CURRENT_USER;
      User user=userDao.findById(currentUser).get();

     return orderDetailDao.findByUser(user);

    }
    public  void placeOrder(OrderInput orderInput,boolean isSingleProductCheckout){
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
            //empty the cart
            if(!isSingleProductCheckout){
              List<Cart> carts=  cartDao.findByUser(user);
              carts.stream().forEach(x -> cartDao.deleteById(x.getCartId()));
            }


            orderDetailDao.save(orderDetail);
        }

    }

    public void markOrderAsDelivered(Integer orderId){
       OrderDetail orderDetail= orderDetailDao.findById(orderId).get();

       if(orderDetail !=null){
           orderDetail.setOrderStatus("Delivered");
           orderDetailDao.save(orderDetail);
       }
    }
}
