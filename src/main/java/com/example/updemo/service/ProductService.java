package com.example.updemo.service;

import com.example.updemo.dto.ProductDto;
import com.example.updemo.dto.ProductWithDiscountDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<ProductDto> findById(long id);

    List<ProductDto> findProductsByIds(List<Long> productIdList);

    List<ProductWithDiscountDto> findProductsWithDiscountByIds(List<Long> productIdList);

    List<ProductDto> findAll();

    List<ProductDto> findAllByCategoryId(long categoryId);

    List<ProductDto> findAllByCategoryName(String categoryName);
}
