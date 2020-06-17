package com.example.updemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class DiscountDto {
    private long id;
    private String name;
    private float percentage;
    private List<ProductDto> products;
}
