package com.example.updemo.dto.mapper;

import com.example.updemo.domain.cart.Cart;
import com.example.updemo.dto.CartDto;
import com.example.updemo.dto.CartWithClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, ClientMapper.class})
public interface CartMapper {
    @Mapping(target = "id", source = "cart.id")
    @Mapping(target = "price", source = "cart.price")
    @Mapping(target = "products", source = "cart.products")
    CartDto cartToDto(Cart cart);

    @Mapping(target = "id", source = "cartWithClientDto.id")
    @Mapping(target = "price", source = "cartWithClientDto.price")
    @Mapping(target = "client", source = "cartWithClientDto.client")
    Cart cartWithClientDtoToCart(CartWithClientDto cartWithClientDto);

    @Mapping(target = "id", source = "cartDto.id")
    @Mapping(target = "price", source = "cartDto.price")
    @Mapping(target = "products", source = "cartDto.products")
    Cart cartDtoToCart(CartDto cartDto);
}
