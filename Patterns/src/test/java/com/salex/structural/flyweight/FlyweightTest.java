package com.salex.structural.flyweight;

import org.junit.jupiter.api.Test;

class FlyweightTest {

    @Test
    public void test() {
        HouseFactory flyweightFactory = new HouseFactory();

        double longitude = 33, latitude = 55;
        for (int i = 0; i < 5; i++) {
            House house = flyweightFactory.getHouse("Brick");
            if (house != null) {
                house.build(longitude, latitude);
            }
            longitude += 0.1;
            latitude += 0.1;
        }

        for (int i = 0; i < 5; i++) {
            House house = flyweightFactory.getHouse("Panel");
            if (house != null) {
                house.build(longitude, latitude);
            }
            longitude += 0.1;
            latitude += 0.1;
        }


    }

}