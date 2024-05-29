package com.example.productweb.form;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

@Data
public class UpdateProductForm {

    @NotEmpty(message = "{Product.Name.Null}")
    @Length(min = 1, max = 50, message="{Product.Name.length}")
    private String updateProductName;


    //    @Digits(integer = 2147483647, fraction = 0)
//    @Range(min=0, max=Integer.MAX_VALUE)
//    @NotNull
    @NotEmpty(message = "{Product.Price.Null}")
    @Range(min=0, max=2147483647, message = "{Product.Price.Range}")
    @Positive(message = "{Product.Price.Positive}")
    private String updateProductPrice;

    private Integer id;
}
