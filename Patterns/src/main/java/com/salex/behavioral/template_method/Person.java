package com.salex.behavioral.template_method;

/**
 * Шаблонный метод (Template method) — поведенческий шаблон проектирования, определяющий основу алгоритма
 * и позволяющий наследникам переопределять некоторые шаги алгоритма, не изменяя его структуру в целом.
 */
public abstract class Person {

    // Template method
    public void workday() {
        wakeUp();
        breakfast();
        work();
        lunch();
        work();
        dinner();
        sleep();
    }

    protected abstract void wakeUp();
    protected abstract void breakfast();
    protected abstract void lunch();
    protected abstract void dinner();
    protected abstract void work();
    protected abstract void sleep();
}
