package com.salex.structural.composite;

/**
 * Компоновщик (Composite) — структурный шаблон проектирования, объединяющий объекты в древовидную структуру для представления
 * иерархии от частного к целому. Компоновщик позволяет клиентам обращаться к отдельным объектам и к
 * группам объектов одинаково
 */
public abstract class AbstractFile {

    protected final String name;
    protected Integer lvl = 0;

    protected AbstractFile(String name) {
        this.name = name;
    }

    public abstract String display();

    protected abstract void setLevel(Integer lvl);
}
