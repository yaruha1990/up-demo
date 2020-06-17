package com.example.updemo.repository;

import com.example.updemo.domain.cart.Cart;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {
}
