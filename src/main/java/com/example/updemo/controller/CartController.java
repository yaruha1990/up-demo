package com.example.updemo.controller;

import com.example.updemo.dto.CartWithClientDto;
import com.example.updemo.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @PostMapping("/purchase")
    public CartWithClientDto makePurchase(@RequestParam("productIdList") List<Long> productIdLIst,
                                          @RequestParam("clientId") long clientId) {
        return cartService.makePurchase(productIdLIst, clientId);
    }
}
