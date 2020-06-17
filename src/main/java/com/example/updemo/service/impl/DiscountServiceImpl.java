package com.example.updemo.service.impl;

import com.example.updemo.domain.discount.Discount;
import com.example.updemo.dto.ProductDto;
import com.example.updemo.dto.ProductWithDiscountDto;
import com.example.updemo.dto.mapper.ProductMapper;
import com.example.updemo.repository.DiscountRepository;
import com.example.updemo.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> calculateDiscount(List<ProductWithDiscountDto> products) {
        return products.stream()
                .map(productWithDiscountDto -> {
                    Discount discount = discountRepository.findDiscountById(productWithDiscountDto.getDiscount().getId());
                    float percentage = discount.getPercentage() / 100;
                    float price = productWithDiscountDto.getPrice();
                    float discountAmount = price * percentage;
                    productWithDiscountDto.setPrice(price - discountAmount);
                    return productMapper.productWithDiscountDtoToProductDto(productWithDiscountDto);
                }).collect(Collectors.toList());
    }
}
