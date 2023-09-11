package com.salex.structural.flyweight;

/**
 * Приспособленец (Flyweight) - структурный шаблон проектирования, который позволяет использовать
 * разделяемые объекты сразу в нескольких контекстах. Данный паттерн используется преимущественно для
 * оптимизации работы с памятью.
 */
public abstract class House {

    protected int stages;

    public abstract void build(double longitude, double latitude);

}
