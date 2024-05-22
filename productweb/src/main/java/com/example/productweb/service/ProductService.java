package com.example.productweb.service;

import com.example.productweb.entity.InsertProduct;
import com.example.productweb.entity.ProductRecord;

import java.util.List;

public interface ProductService {

    List<ProductRecord> findAll();

    ProductRecord findById(int id);

    int insert(InsertProduct product);
    int update(ProductRecord productRecord);

    int delete(int id);

}