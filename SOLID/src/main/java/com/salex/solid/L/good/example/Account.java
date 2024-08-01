package com.salex.solid.L.good.example;

import java.math.BigDecimal;

public interface Account {
    BigDecimal balance(String numberAccount);

    void refill(String numberAccount, BigDecimal sum);

}
