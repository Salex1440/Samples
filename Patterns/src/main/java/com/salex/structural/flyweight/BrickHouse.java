package com.salex.structural.flyweight;

public class BrickHouse extends House {

    public BrickHouse() {
        stages = 5;
    }

    @Override
    public void build(double longitude, double latitude) {
        System.out.println("Построен кирпичный дом из " + stages + " этажей по координатам (" +
            longitude + ", " + latitude + ")");
    }
}
