package com.salex.solid.L.good.example;

import java.math.BigDecimal;

public class SalaryAccount extends PaymentAccount {
    @Override
    public BigDecimal balance(String numberAccount) {
        //logic
        return new BigDecimal(0);
    }

    @Override
    public void refill(String numberAccount, BigDecimal sum) {
        //logic
    }

    @Override
    public void payment(String numberAccount, BigDecimal sum) {
        //logic
    }
}