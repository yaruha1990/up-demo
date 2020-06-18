package com.example.updemo.service.impl;

import com.example.updemo.domain.discount.Discount;
import com.example.updemo.dto.ProductDto;
import com.example.updemo.dto.ProductWithDiscountDto;
import com.example.updemo.dto.mapper.DiscountMapper;
import com.example.updemo.dto.mapper.ProductMapper;
import com.example.updemo.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final ProductMapper productMapper;
    private final DiscountMapper discountMapper;

    @Override
    public List<ProductDto> calculateDiscount(List<ProductWithDiscountDto> products) {
        return products.stream()
                .map(productWithDiscountDto -> {
                    float productPriceWithDiscount = calculateProductPriceWithDiscount(productWithDiscountDto);
                    productWithDiscountDto.setPrice(productPriceWithDiscount);
                    return productMapper.productWithDiscountDtoToProductDto(productWithDiscountDto);
                }).collect(Collectors.toList());
    }

    public float calculateProductPriceWithDiscount(ProductWithDiscountDto product) {
        Discount discount = discountMapper.discountWithoutProductsToDiscount(product.getDiscount());
        float percentage = discount.getPercentage() / 100;
        float price = product.getPrice();
        float discountAmount = price * percentage;
        return price - discountAmount;
    }
}
