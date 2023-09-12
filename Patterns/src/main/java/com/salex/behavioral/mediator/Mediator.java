package com.salex.behavioral.mediator;

public interface Mediator {
    void send(String msg, Colleague from);
}
