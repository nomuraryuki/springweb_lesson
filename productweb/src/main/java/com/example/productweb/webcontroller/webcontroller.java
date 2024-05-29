package com.example.productweb.webcontroller;

import com.example.productweb.entity.InsertProduct;
import com.example.productweb.entity.ProductRecord;
import com.example.productweb.form.AddProductForm;
import com.example.productweb.form.UpdateProductForm;
import com.example.productweb.service.PgProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class webcontroller {

    @Autowired
    PgProductService pgProductService;


    @GetMapping("product-list")
    public String productList(Model model) {
        // ロジックをServiceに任せる
        model.addAttribute("productList", pgProductService.findAll());
        return "product-list";
    }

    @GetMapping("/product/{id}")
    public String product(@PathVariable("id") int id, Model model ){
            model.addAttribute("productId", pgProductService.findById(id));
            return "product";
    }

    @PostMapping("/product/{id}")
    public String productDelete(@PathVariable("id") int id,@ModelAttribute("updateProductForm")  UpdateProductForm updateProductForm,Model model) {
        model.addAttribute("productId", pgProductService.findById(id));
        System.out.println(id);
        pgProductService.delete(id);

            return "redirect:/product-list";
    }

    @GetMapping("/product-add")
    public String index(@ModelAttribute("addProductForm") AddProductForm addProductForm) {
        return "product-add";
    }
    @PostMapping("/product-add")
    public String addProduct(@Validated @ModelAttribute("addProductForm") AddProductForm addProductForm, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "product-add";
        }
        else{
            var insertProduct = new InsertProduct(addProductForm.getAddProductName(),Integer.parseInt(addProductForm.getAddProductPrice()));
            pgProductService.insert(insertProduct);
            return "redirect:/product-list";
        }
    }

    @GetMapping("product/update/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("updateProductForm")UpdateProductForm updateProductForm, Model model){
        model.addAttribute("productId", pgProductService.findById(id));
        ProductRecord productRecord =pgProductService.findById(id);
        updateProductForm.setUpdateProductPrice(String.valueOf(productRecord.price()));
        updateProductForm.setUpdateProductName(productRecord.name());
        return "update";
    }

    @PostMapping("product/update/{id}")
    public String updatePost(@PathVariable("id")int id,  @Validated @ModelAttribute("updateProductForm")  UpdateProductForm updateProductForm, BindingResult bindingResult, Model model) {
        model.addAttribute("productId", pgProductService.findById(id));
        if(bindingResult.hasErrors()) {
            return "update";
        }
        else{
            var insertProduct = new ProductRecord(id,updateProductForm.getUpdateProductName(),Integer.parseInt(updateProductForm.getUpdateProductPrice()));
            pgProductService.update(insertProduct);
            return "redirect:/product-list";
        }
    }

    @GetMapping("/product-management")
    public String management(Model model) {
        return "product-management";
    }


}
