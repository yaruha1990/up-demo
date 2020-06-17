package com.example.updemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ClientWithoutCartsDto {
    private long id;
    private String email;
    private float balance;
}
