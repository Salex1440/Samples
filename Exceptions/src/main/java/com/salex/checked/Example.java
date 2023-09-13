package com.salex.checked;

public class Example {

    public static void main(String[] args) {

        // Компилятор выдаст сообщение об ошибке
//        Thread.currentThread().wait(1000);
        try {
            Thread.currentThread().wait(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
