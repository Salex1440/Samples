package com.salex.solid.D.good.example;

public class Shop {

    private Payment payment;

    public Shop(Payment payment) {
        this.payment = payment;
    }

    public void doPayment(int amount) {
        payment.doTransaction(amount);
    }

}

// Shop shop = new Shop(new Cash());
// Shop shop = new Shop(new BankCard());
// Shop shop = new Shop(new Nfc());