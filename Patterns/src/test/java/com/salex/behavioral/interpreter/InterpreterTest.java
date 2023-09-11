package com.salex.behavioral.interpreter;

import org.junit.jupiter.api.Test;

import java.util.List;

class InterpreterTest {

    @Test
    public void test() {
        Expression query = new Select("name", new From("people"));
        Context ctx = new Context();
        List<String> result = query.interpret(ctx);
        System.out.println(result);

        Expression query2 = new Select("*", new From("people"));
        List<String> result2 = query2.interpret(ctx);
        System.out.println(result2);

        Expression query3 = new Select("name",
            new From("people"
            ));
        List<String> result3 = query3.interpret(ctx);
        System.out.println(result3);
    }

}