package com.example.updemo.domain.product;

import com.example.updemo.domain.cart.Cart;
import com.example.updemo.domain.category.Category;
import com.example.updemo.domain.discount.Discount;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private float price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany(mappedBy = "products")
    private List<Cart> carts;
    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;
}
