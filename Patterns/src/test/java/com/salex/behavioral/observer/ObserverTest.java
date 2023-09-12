package com.salex.behavioral.observer;

import org.junit.jupiter.api.Test;

class ObserverTest {

    @Test
    public void test() {
        Observer observer = new ObserverImpl();
        Subject subject = new Subject("state1");
        observer.subscribe(subject);

        subject.setState("state2");
        subject.setState("state3");
    }

}