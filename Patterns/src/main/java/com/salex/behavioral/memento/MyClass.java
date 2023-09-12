package com.salex.behavioral.memento;

public class MyClass {

    private String state;

    public MyClass(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento save() {
        return new Memento(state);
    }

    public void load(Memento memento) {
        this.state = memento.getState();
    }
}
