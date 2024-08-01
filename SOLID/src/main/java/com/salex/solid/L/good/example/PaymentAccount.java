package com.salex.solid.L.good.example;

import java.math.BigDecimal;

public interface PaymentAccount extends Account {
    void payment(String numberAccount, BigDecimal sum);
    
}