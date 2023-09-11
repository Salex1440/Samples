package com.salex.creational.prototype;

public abstract class Prototype {

    protected String context;

    public Prototype(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public abstract Prototype clone();

}
