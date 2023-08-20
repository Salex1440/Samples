package com.salex.solid.O.good.example;

public class Blacksmith implements Npc {
    @Override
    public void greet() {
        System.out.println("Hello, do you need a new armor?");
    }
}
