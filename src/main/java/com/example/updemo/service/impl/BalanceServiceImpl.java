package com.example.updemo.service.impl;

import com.example.updemo.service.BalanceService;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {
    @Override
    public boolean hasClientEnoughMoney(float clientBalance, float cartPrice) {
        return clientBalance - cartPrice >= 0;
    }
}
