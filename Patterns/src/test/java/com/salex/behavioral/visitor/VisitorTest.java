package com.salex.behavioral.visitor;

import org.junit.jupiter.api.Test;

import java.util.List;


class VisitorTest {

    @Test
    public void test() {
        List<Element> list = List.of(new A(), new B());
        Visitor visitor = new GetType();
        for (Element e : list) {
            e.accept(visitor);
        }
    }

}