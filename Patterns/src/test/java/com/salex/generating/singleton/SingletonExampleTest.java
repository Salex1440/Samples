package com.salex.generating.singleton;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingletonExampleTest {

    @Test
    public void singletonTest() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<Singleton> instance1 = Singleton::getInstance;
        Callable<Singleton> instance2 = Singleton::getInstance;
        Future<Singleton> future1 = executorService.submit(instance1);
        Future<Singleton> future2 = executorService.submit(instance2);

        assertEquals(future1.get(), future2.get());
    }

}