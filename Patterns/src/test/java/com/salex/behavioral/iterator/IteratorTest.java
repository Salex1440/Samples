package com.salex.behavioral.iterator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteratorTest {

    @Test
    public void test() {
        Container<String> container = new Container<>();
        container.add("A");
        container.add("B");
        container.add("C");
        container.add("D");
        Iterator<String> iterator = container.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}