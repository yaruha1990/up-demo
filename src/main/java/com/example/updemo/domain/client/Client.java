package com.example.updemo.domain.client;

import com.example.updemo.domain.cart.Cart;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private float balance;
    @OneToMany(mappedBy = "client")
    private List<Cart> carts;
}
