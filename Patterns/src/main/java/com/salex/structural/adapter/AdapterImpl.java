package com.salex.structural.adapter;

public class AdapterImpl implements Adapter {

    private final FinalClass target;

    public AdapterImpl(FinalClass target) {
        this.target = target;
    }

    @Override
    public String doSth(String context, int repeats) {
        String s = context.repeat(repeats);
        target.doSth(s);
        return s;
    }
}
