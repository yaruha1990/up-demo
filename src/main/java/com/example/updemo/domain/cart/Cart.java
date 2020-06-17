package com.example.updemo.domain.cart;

import com.example.updemo.domain.client.Client;
import com.example.updemo.domain.product.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float price;
    @ManyToMany(targetEntity = Product.class)
    @JoinTable(name = "carts_products",
            joinColumns = {@JoinColumn(name = "cart_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<Product> products;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
