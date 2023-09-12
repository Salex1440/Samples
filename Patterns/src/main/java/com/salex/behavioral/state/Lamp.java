package com.salex.behavioral.state;

public class Lamp {

    private State state;

    public Lamp() {
        state = new StateOff();
    }

    public void toggle() {
        state = state.next();
        System.out.println(state.getState());
    }
}
