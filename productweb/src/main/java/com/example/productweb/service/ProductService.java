package com.example.productweb.service;

import com.example.productweb.entity.ProductRecord;

import java.util.List;

public interface ProductService {

    List<ProductRecord> findAll();

    ProductRecord findById(int id);

}