package com.example.updemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class CategoryDto {
    private long id;
    private String name;
    private List<ProductDto> products;
}
