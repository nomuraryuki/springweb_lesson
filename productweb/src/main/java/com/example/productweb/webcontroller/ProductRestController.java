package com.example.productweb.webcontroller;

import com.example.productweb.entity.InsertProduct;
import com.example.productweb.entity.ProductRecord;
import com.example.productweb.service.PgProductService;
import com.example.productweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/api/products")
    public ResponseEntity<List<ProductRecord>> productManagement() {
        try {
            var productList = productService.findAll();
            System.out.println(productList.get(0).id());
            // データとステータスコード200番を返す
            return new ResponseEntity<>(productList, HttpStatus.OK);
        } catch (Exception e) {
            // ステータスコード400番を返す
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/api/product")
    public ResponseEntity productById(@Validated @RequestBody InsertProduct insertProduct){
        var productAdd = productService.insert(insertProduct);
//        System.out.println(insertProduct);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

//    @GetMapping("/api/product/{id}")
//    public ResponseEntity()

}
