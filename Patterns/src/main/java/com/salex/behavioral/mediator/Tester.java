package com.salex.behavioral.mediator;

public class Tester extends Colleague {

    @Override
    public void notify(String msg) {
        System.out.println("Сообщение тестеру: " + msg);
    }
}
