package com.example.updemo.dto.mapper;

import com.example.updemo.domain.product.Product;
import com.example.updemo.dto.ProductDto;
import com.example.updemo.dto.ProductWithDiscountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = DiscountMapper.class)
public interface ProductMapper {
    @Mapping(target = "id", source = "product.id")
    @Mapping(target = "name", source = "product.name")
    @Mapping(target = "price", source = "product.price")
    ProductDto productToDto(Product product);

    @Mapping(target = "id", source = "product.id")
    @Mapping(target = "name", source = "product.name")
    @Mapping(target = "price", source = "product.price")
    @Mapping(target = "discount", source = "product.discount")
    ProductWithDiscountDto productWithDiscountToDto(Product product);

    @Mapping(target = "id", source = "productWithDiscountDto.id")
    @Mapping(target = "name", source = "productWithDiscountDto.name")
    @Mapping(target = "price", source = "productWithDiscountDto.price")
    ProductDto productWithDiscountDtoToProductDto(ProductWithDiscountDto productWithDiscountDto);

    @Mapping(target = "id", source = "productDto.id")
    @Mapping(target = "name", source = "productDto.name")
    @Mapping(target = "price", source = "productDto.price")
    Product productDtoToProduct(ProductDto productDto);
}
