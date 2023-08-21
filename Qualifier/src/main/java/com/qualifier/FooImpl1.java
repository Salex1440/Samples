package com.qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("FooImpl1")
public class FooImpl1 implements Foo {
    @Override
    public void bar() {
        System.out.println("FooImpl1");
    }
}
