package com.example.updemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductWithDiscountDto {
    private long id;
    private String name;
    private float price;
    private DiscountWithoutProductsDto discount;
}
