package com.salex.generating.prototype;

public class PrototypeImpl extends Prototype {


    public PrototypeImpl(String context) {
        super(context);
    }

    @Override
    public Prototype clone() {
        return new PrototypeImpl(this.context);
    }

}
