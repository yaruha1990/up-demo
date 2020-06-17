package com.example.updemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class CartDto {
    private long id;
    private float price;
    private List<ProductDto> products;
}
