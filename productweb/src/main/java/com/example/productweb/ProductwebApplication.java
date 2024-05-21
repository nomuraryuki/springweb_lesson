package com.example.productweb;

import com.example.productweb.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductwebApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(ProductwebApplication.class, args);

		var productsService = context.getBean(ProductService.class);
//		var list = productsService.findAll();
//		list.stream().forEach(System.out::println);

//		var products = productsService.findById(1); // IDが1のユーザーのみを取得
//		System.out.println(products.id());
	}

}
