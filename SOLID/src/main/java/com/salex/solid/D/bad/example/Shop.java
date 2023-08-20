package com.salex.solid.D.bad.example;

public class Shop {

    private Cash cash;

    public Shop(Cash cash) {
        this.cash = cash;
    }

    public void doPayment(int amount) {
        cash.doTransaction(amount);
    }
}
