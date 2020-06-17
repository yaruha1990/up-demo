package com.example.updemo.domain.discount;

import com.example.updemo.domain.product.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private float percentage;
    @OneToMany(mappedBy = "discount")
    private List<Product> products;
}
