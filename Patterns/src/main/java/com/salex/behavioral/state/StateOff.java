package com.salex.behavioral.state;

public class StateOff implements State {
    private final String NAME = "OFF";
    private final static State nextState = new StateOn();
    @Override
    public State next() {
        return nextState;
    }
    @Override
    public String getState() {
        return NAME;
    }
}
