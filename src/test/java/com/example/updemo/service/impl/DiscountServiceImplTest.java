package com.example.updemo.service.impl;

import com.example.updemo.domain.discount.Discount;
import com.example.updemo.dto.DiscountWithoutProductsDto;
import com.example.updemo.dto.ProductWithDiscountDto;
import com.example.updemo.dto.mapper.DiscountMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DiscountServiceImplTest {
    @Mock
    private DiscountMapper discountMapper;
    @InjectMocks
    private DiscountServiceImpl discountService;

    @Test
    public void calculateDiscountTest() {
        //given
        DiscountWithoutProductsDto discountDto = new DiscountWithoutProductsDto();
        discountDto.setPercentage(10);
        Discount discount = new Discount();
        discount.setPercentage(10);
        ProductWithDiscountDto product = new ProductWithDiscountDto();
        product.setPrice(500);
        product.setDiscount(discountDto);
        when(discountMapper.discountWithoutProductsToDiscount(any(DiscountWithoutProductsDto.class))).thenReturn(discount);

        //when
        float productPriceWithDiscount = discountService.calculateProductPriceWithDiscount(product);

        //then
        assertThat(productPriceWithDiscount).isEqualTo(450.0f);
    }

}