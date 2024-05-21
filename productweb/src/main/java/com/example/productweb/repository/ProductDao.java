package com.example.productweb.repository;

import com.example.productweb.entity.ProductRecord;

import java.util.List;

public interface ProductDao {
    List<ProductRecord> findAll();

    ProductRecord findById(int id);


}
