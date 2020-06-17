package com.example.updemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DiscountWithoutProductsDto {
    private long id;
    private String name;
    private float percentage;
}
