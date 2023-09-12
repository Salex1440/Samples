package com.salex.behavioral.observer;

public class ObserverImpl implements Observer {

    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    @Override
    public void update() {
        System.out.println("New subject's state is: " + subject.getState());
    }

    @Override
    public void subscribe(Object o) {
        subject = (Subject) o;
        subject.attach(this);
    }
}
