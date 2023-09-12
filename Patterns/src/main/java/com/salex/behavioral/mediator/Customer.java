package com.salex.behavioral.mediator;

public class Customer extends Colleague {

    @Override
    public void notify(String msg) {
        System.out.println("Сообщение заказчику: " + msg);
    }
}
