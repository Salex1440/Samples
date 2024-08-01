package com.salex.solid.L.bad.example;

import java.math.BigDecimal;

public interface Account {
    BigDecimal balance(String numberAccount);
    void refill(String numberAccount, BigDecimal sum);
    void payment(String numberAccount, BigDecimal sum);

}
