package com.salex.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class HouseFactory {

    Map<String, House> houses = new HashMap<>();

    public HouseFactory() {
        houses.put("Panel", new PanelHouse());
        houses.put("Brick", new BrickHouse());
    }

    public House getHouse(String type) {
        if (houses.containsKey(type)) {
            return houses.get(type);
        }
        return null;
    }
}
