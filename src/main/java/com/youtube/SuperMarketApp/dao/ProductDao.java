package com.youtube.SuperMarketApp.dao;

import com.youtube.SuperMarketApp.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends CrudRepository<Product,Integer> {

}
