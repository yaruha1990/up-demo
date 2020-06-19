package com.example.updemo.service.impl;

import com.example.updemo.dto.ClientDto;
import com.example.updemo.dto.ProductDto;
import com.example.updemo.service.ClientService;
import com.example.updemo.service.DiscountService;
import com.example.updemo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceImplTest {
    @Mock
    private ProductService productService;
    @Mock
    private DiscountService discountService;
    @Mock
    private ClientService clientService;
    @Spy
    private BalanceServiceImpl balanceService;
    @InjectMocks
    private CartServiceImpl cartService;

    @Test
    public void shouldThrowExceptionIfClientNotExists() {
        final Executable closure = () -> cartService.makePurchase(newArrayList(1L, 2L, 3L), 5);
        assertThrows(IllegalArgumentException.class, closure, "There is no such client");
    }

    @Test
    public void shouldThrowExceptionIfClientHasNotEnoughMoney() {
        //given
        ProductDto productDto = new ProductDto();
        productDto.setPrice(200);
        ArrayList<ProductDto> products = newArrayList(productDto);
        ClientDto client = new ClientDto();
        client.setBalance(100);
        when(discountService.calculateDiscount(anyList())).thenReturn(products);
        when(clientService.findById(anyLong())).thenReturn(Optional.of(client));

        assertThatThrownBy(() -> cartService.makePurchase(newArrayList(1L, 2L, 3L), 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Client has not enough money");
    }

}