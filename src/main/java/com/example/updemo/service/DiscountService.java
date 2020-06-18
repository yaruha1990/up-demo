package com.example.updemo.service;

import com.example.updemo.dto.ProductDto;
import com.example.updemo.dto.ProductWithDiscountDto;

import java.util.List;

public interface DiscountService {
    List<ProductDto> calculateDiscount(List<ProductWithDiscountDto> products);

    float calculateProductPriceWithDiscount(ProductWithDiscountDto product);
}
