package org.example;

import org.example.annotation.Max;

public class Holder {

    @Max(2)
    private final int value;

    public Holder(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
