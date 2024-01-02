package com.salex;

public class B extends A {

    B() {
        System.out.println("B constructor: " + overloaded());
    }

    public String overloaded() {
        return "B.overloaded()";
    }

//    public void finalMethod() {
//        // Cannot be overloaded
//    }

}
