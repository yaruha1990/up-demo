package com.example.updemo.dto.mapper;

import com.example.updemo.domain.discount.Discount;
import com.example.updemo.dto.DiscountDto;
import com.example.updemo.dto.DiscountWithoutProductsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface DiscountMapper {
    @Mapping(target = "id", source = "discount.id")
    @Mapping(target = "name", source = "discount.name")
    @Mapping(target = "percentage", source = "discount.percentage")
    @Mapping(target = "products", source = "discount.products")
    DiscountDto discountToDto(Discount discount);

    @Mapping(target = "id", source = "discount.id")
    @Mapping(target = "name", source = "discount.name")
    @Mapping(target = "percentage", source = "discount.percentage")
    DiscountWithoutProductsDto discountWithoutProductsToDto(Discount discount);

    @Mapping(target = "id", source = "discountDto.id")
    @Mapping(target = "name", source = "discountDto.name")
    @Mapping(target = "percentage", source = "discountDto.percentage")
    @Mapping(target = "products", source = "discountDto.products")
    Discount discountDtoToDiscount(DiscountDto discountDto);
}
