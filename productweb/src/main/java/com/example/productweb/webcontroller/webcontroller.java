package com.example.productweb.webcontroller;

import com.example.productweb.entity.ProductRecord;
import com.example.productweb.service.PgProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class webcontroller {

    @Autowired
    PgProductService pgProductService;


    @GetMapping("product_list")
    public String productList(Model model) {
        // ロジックをServiceに任せる
        model.addAttribute("productList", pgProductService.findAll());
        return "product_list";
    }

    @GetMapping("/product/{id}")
    public String product(@PathVariable("id") int id, Model model ){
            model.addAttribute("productId", pgProductService.findById(id));
            return "product";
    }

}
