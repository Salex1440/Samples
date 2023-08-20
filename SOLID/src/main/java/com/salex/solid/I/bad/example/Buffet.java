package com.salex.solid.I.bad.example;

import com.salex.solid.I.bad.example.Restaurant;

public class Buffet implements Restaurant {
    @Override
    public void cookOrder() {
        // logic
    }

    @Override
    public void makeDrink() {
        // logic
    }

    @Override
    public void bringOrder() {
        // ???
    }

    @Override
    public void receiveOrder() {
        // logic
    }

    @Override
    public void bill() {
        // logic
    }

    @Override
    public void receiveTips() {
        // ???
    }
}
