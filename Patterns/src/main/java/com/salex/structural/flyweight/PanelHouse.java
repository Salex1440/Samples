package com.salex.structural.flyweight;

public class PanelHouse extends House {

    public PanelHouse() {
        stages = 16;
    }

    @Override
    public void build(double longitude, double latitude) {
        System.out.println("Построен панельный дом из " + stages + " этажей по координатам (" +
            longitude + ", " + latitude + ")");
    }

}
