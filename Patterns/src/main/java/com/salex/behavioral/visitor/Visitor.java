package com.salex.behavioral.visitor;

/**
 * Посетитель (visitor) — поведенческий шаблон проектирования, описывающий операцию, которая выполняется
 * над объектами других классов. При изменении visitor нет необходимости изменять обслуживаемые классы.
 */
public interface Visitor {
    void visit(A a);
    void visit(B b);
}
