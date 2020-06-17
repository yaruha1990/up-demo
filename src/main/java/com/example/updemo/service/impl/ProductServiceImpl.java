package com.example.updemo.service.impl;

import com.example.updemo.domain.product.Product;
import com.example.updemo.dto.ProductDto;
import com.example.updemo.dto.ProductWithDiscountDto;
import com.example.updemo.dto.mapper.ProductMapper;
import com.example.updemo.repository.ProductRepository;
import com.example.updemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Optional<ProductDto> findById(long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(productMapper::productToDto);
    }

    @Override
    public List<ProductDto> findProductsByIds(List<Long> productIdList) {
        List<Product> products = productRepository.findProductsByIds(productIdList);
        return products.stream()
                .map(productMapper::productToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductWithDiscountDto> findProductsWithDiscountByIds(List<Long> productIdList) {
        List<Product> products = productRepository.findProductsByIds(productIdList);
        return products.stream()
                .map(productMapper::productWithDiscountToDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::productToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findAllByCategoryId(long categoryId) {
        List<Product> products = productRepository.findAllByCategoryId(categoryId);
        return products.stream()
                .map(productMapper::productToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findAllByCategoryName(String categoryName) {
        List<Product> products = productRepository.findAllByCategoryName(categoryName);
        return products.stream()
                .map(productMapper::productToDto)
                .collect(Collectors.toList());
    }
}
