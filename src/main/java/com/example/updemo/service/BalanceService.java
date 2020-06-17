package com.example.updemo.service;

public interface BalanceService {
    boolean hasClientEnoughMoney(float clientBalance, float cartPrice);
}
