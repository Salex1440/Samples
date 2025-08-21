package com.salex;

public class Main2 {

    public static class Parent {
        public Parent() {
            printName();
        }

        public void printName() {
            System.out.println("Parent");
        }
    }

    public static class Child extends Parent {
        public Child() {
            printName();
        }

        public void printName() {
            System.out.println("Child");
        }
    }

    /**
     * Два раза выведется Child
     * При вызове конструктора Child происходит неявный вызов конструктора Parent,
     * который вызывает метод printName. Хотя переменная и объявлена как тип Parent,
     * инстанциирована она типом Child, у которого метод printName() переопределен.
     * Так происходит первая печать Child.
     */
    public static void main(String[] args) {
        Parent parent = new Child();
    }
}
