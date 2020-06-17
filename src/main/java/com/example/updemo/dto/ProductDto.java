package com.example.updemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductDto {
    private long id;
    private String name;
    private float price;
}
