package com.example.SuperMarketApp.dao;


import com.example.SuperMarketApp.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Product,Integer> {

    public List<Product> findAll(Pageable pageable);
}
