package com.salex.solid.L.good.example;

import java.math.BigDecimal;

public class DepositAccount extends Account {
    @Override
    public BigDecimal balance(String numberAccount) {
        //logic
        return new BigDecimal(0);
    }

    @Override
    public void refill(String numberAccount, BigDecimal sum) {
        //logic
    }
}