package com.salex;

public class A {

    A() {
        System.out.println("A constructor: " + overloaded());
    }

    public String overloaded() {
        return "A.overloaded()";
    }

    public final void finalMethod() {
        System.out.println("final");
    }

}
