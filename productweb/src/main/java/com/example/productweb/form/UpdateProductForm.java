package com.example.productweb.form;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

@Data
public class UpdateProductForm {

    @NotEmpty(message = "商品名は必須入力です")
    @Length(min = 1, max = 50)
    private String updateProductName;


    //    @Digits(integer = 2147483647, fraction = 0)
    @Range(min=0, max=Integer.MAX_VALUE)
    @NotNull
    private Integer updateProductPrice;

    private Integer id;
}
