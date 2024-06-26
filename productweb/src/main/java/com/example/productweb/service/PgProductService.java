package com.example.productweb.service;
//import com.example.productweb.Exception.ProductNotFoundException;
import com.example.productweb.Exception.ProductNotFoundException;
import com.example.productweb.entity.ProductRecord;
import com.example.productweb.repository.ProductDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PgProductService implements ProductService {

    private ProductDao productDao;


    @Override
    public List<ProductRecord> findAll() {
        return productDao.findAll();
    }

    @Override
    public ProductRecord findById(int id) {

        if (productDao.findById(id) == null) throw new ProductNotFoundException();

        else {return productDao.findById(id);}
    }
}
