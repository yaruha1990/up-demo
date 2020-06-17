package com.example.updemo.service.impl;

import com.example.updemo.domain.cart.Cart;
import com.example.updemo.dto.CartWithClientDto;
import com.example.updemo.dto.ClientDto;
import com.example.updemo.dto.ProductDto;
import com.example.updemo.dto.ProductWithDiscountDto;
import com.example.updemo.dto.mapper.CartMapper;
import com.example.updemo.dto.mapper.ClientMapper;
import com.example.updemo.repository.CartRepository;
import com.example.updemo.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final ProductService productService;
    private final DiscountService discountService;
    private final ClientService clientService;
    private final BalanceService balanceService;
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final ClientMapper clientMapper;

    @Override
    public CartWithClientDto save(CartWithClientDto cartWithClientDto) {
        Cart cart = cartMapper.cartWithClientDtoToCart(cartWithClientDto);
        cartRepository.save(cart);
        return cartWithClientDto;
    }

    @Override
    public CartWithClientDto makePurchase(List<Long> productIdList, long clientId) {
        List<ProductWithDiscountDto> products = productService.findProductsWithDiscountByIds(productIdList);
        List<ProductDto> productsWithDiscount = discountService.calculateDiscount(products);
        Optional<ClientDto> clientDtoOptional = clientService.findById(clientId);
        if (clientDtoOptional.isPresent()) {
            ClientDto clientDto = clientDtoOptional.get();
            float cartPrice = calculateCartPrice(productsWithDiscount);
            float clientBalance = clientDto.getBalance();
            if (balanceService.hasClientEnoughMoney(clientBalance, cartPrice)) {
                clientDto.setBalance(clientBalance - cartPrice);
                CartWithClientDto cartWithClientDto = new CartWithClientDto();
                cartWithClientDto.setClient(clientMapper.clientDtoToClientWithoutCartsDto(clientDto));
                cartWithClientDto.setPrice(cartPrice);
                cartWithClientDto.setProducts(productsWithDiscount);
                clientService.save(clientDto);
                return save(cartWithClientDto);
            }
            throw new IllegalArgumentException("Client has not enough money");
        }
        throw new IllegalArgumentException("There is no such client");
    }

    @Override
    public float calculateCartPrice(List<ProductDto> products) {
        return (float) products.stream()
                .mapToDouble(ProductDto::getPrice)
                .sum();
    }
}
