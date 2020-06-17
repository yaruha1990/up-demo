package com.example.updemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ClientDto {
    private long id;
    private String email;
    private float balance;
    private List<CartDto> carts;
}
