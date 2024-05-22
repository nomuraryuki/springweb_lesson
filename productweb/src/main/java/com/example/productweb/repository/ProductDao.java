package com.example.productweb.repository;

import com.example.productweb.entity.InsertProduct;
import com.example.productweb.entity.ProductRecord;

import java.util.List;

public interface ProductDao {
    List<ProductRecord> findAll();

    ProductRecord findById(int id);

    int insert(InsertProduct insertProduct);
    int update(ProductRecord productRecord);

    int delete(int id);
}
