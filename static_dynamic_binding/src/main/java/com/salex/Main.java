package com.salex;

/**
 * In Java static binding refers to the execution of a program where type of object is
 * determined/known at compile time i.e when compiler executes the code it know the type
 * of object or class to which object belongs.While in case of dynamic binding the type
 * of object is determined at runtime.
 *
 * Also static binding uses type of class to bind while dynamic binding uses type of object
 * as the resolution happens only at runtime because object only created during runtime
 * due to which dynamic binding becomes slower than in case of static binding.
 *
 * As private,final and static modifiers binds to the class level so methods and variables
 * uses static binding and bonded by compiler while the other methods are bonded during
 * runtime based upon runtime object.
 *
 * In general we can say that overloaded methods are bonded using static binding
 * while overridden methods are bonded using dynamic binding.
 */

public class Main {
    public static void main(String[] args) {

        A a = new B();
        B b = new B();

        // Static binding
        Object o = new Cat();
        overloadedMethod(o);
        Animal animal = new Cat();
        overloadedMethod(animal);
        Cat cat = new Cat();
        overloadedMethod(cat);

        // Dynamic binding
        animal.say();
        cat.say();
        Animal animal2 = new Animal();
        animal2.say();
    }

    public static void overloadedMethod(Object o) {
        System.out.println("Object: " + o.getClass() + " was passed");
    }

    public static void overloadedMethod(Animal o) {
        System.out.println("Animal: " + o.getClass() + " was passed");
    }

    public static void overloadedMethod(Cat o) {
        System.out.println("Cat: " + o.getClass() + " was passed");
    }

}