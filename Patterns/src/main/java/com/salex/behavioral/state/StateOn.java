package com.salex.behavioral.state;

public class StateOn implements State {
    private final String NAME = "ON";
    private final static State nextState = new StateOff();
    @Override
    public State next() {
        return nextState;
    }
    @Override
    public String getState() {
        return NAME;
    }
}
