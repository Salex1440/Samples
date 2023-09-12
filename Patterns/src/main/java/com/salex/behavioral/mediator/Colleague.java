package com.salex.behavioral.mediator;

public abstract class Colleague {

    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void send(String msg) {
        mediator.send(msg, this);
    }

    public abstract void notify(String msg);

}
