package com.salex.solid.D.good.example;

public class Shop {

    private Payment payment;

    public Shop(Payment payment) {

    }

    public void doPayment(int amount) {
        payment.doTransaction(amount);
    }

}
