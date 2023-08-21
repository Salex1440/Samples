package com.qualifier;

import org.springframework.stereotype.Component;

@Component("FooImpl2")
public class FooImpl2 implements Foo {
    @Override
    public void bar() {
        System.out.println("FooImpl2");
    }
}
