package com.salex.behavioral.mediator;

public class Developer extends Colleague {

    @Override
    public void notify(String msg) {
        System.out.println("Сообщение разработчику: " + msg);
    }
}
