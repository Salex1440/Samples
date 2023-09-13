package com.salex.unchecked;

public class Example {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught!");
        }
        // Компилятор не предупредит об ошибке.
        // Она возникнет во время выполнения программы.
        System.out.println(a / b);
    }
}
