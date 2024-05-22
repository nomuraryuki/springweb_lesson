package com.example.productweb.form;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

@Data
public class AddProductForm {

    @NotEmpty(message = "商品名は必須入力です")
    @Length(min = 1, max = 50)
    private String addProductName;


//    @Digits(integer = 2147483647, fraction = 0)
    @NotNull
    @Max(value = Integer.MAX_VALUE, message = "2147483647")
    @Min(0)
//    @Range(min=0, max=2147483647, message = "2147483647です")
    private Integer  addProductPrice;
}
