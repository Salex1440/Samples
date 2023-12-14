package com.salex.behavioral.memento;

/**
* Memento (Хранитель) - поведенческий шаблон проектирования. не нарушая инкапсуляцию, определяет и сохраняет внутреннее
* состояние объекта и позволяет позже восстанавливать объект в этом состоянии.
*/
public class Memento {

    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
