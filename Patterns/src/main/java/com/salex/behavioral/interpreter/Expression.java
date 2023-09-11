package com.salex.behavioral.interpreter;

import java.util.List;

/**
 * Интерпретатор (Interpreter) — поведенческий шаблон проектирования, решающий часто встречающуюся,
 * но подверженную изменениям, задачу. Также известен как Little (Small) Language
 */
public interface Expression {

    List<String> interpret(Context ctx);
}
