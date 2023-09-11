package com.salex.structural.decorator;

/**
 * Декоратор (Decorator) — структурный шаблон проектирования, предназначенный для динамического подключения дополнительного поведения к объекту.
 * Шаблон Декоратор предоставляет гибкую альтернативу практике создания подклассов с целью расширения функциональности.
 */
public abstract class Decorator {

    protected final Service service;

    protected Decorator(Service service) {
        this.service = service;
    }

    public abstract void bar();

}
