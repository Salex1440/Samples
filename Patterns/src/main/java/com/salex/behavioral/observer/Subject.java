package com.salex.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private String state;
    private final List<Observer> observerList = new ArrayList<>();

    public Subject(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        emit();
    }

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    private void emit() {
        for (Observer o : observerList) {
            o.update();
        }
    }
}
