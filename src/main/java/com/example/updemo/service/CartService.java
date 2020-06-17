package com.example.updemo.service;

import com.example.updemo.dto.CartWithClientDto;
import com.example.updemo.dto.ProductDto;

import java.util.List;

public interface CartService {
    CartWithClientDto save(CartWithClientDto cartWithClientDto);

    CartWithClientDto makePurchase(List<Long> productIdList, long clientId);

    float calculateCartPrice(List<ProductDto> products);
}
