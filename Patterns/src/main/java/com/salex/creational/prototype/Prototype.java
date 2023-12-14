package com.salex.creational.prototype;

/**
 * Prototype (Прототип) - порождающий шаблон проектирования.
 * Определяет логику создания новых объектов с помощью копирования
 * состояния объекта-прототипа.
 */
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
