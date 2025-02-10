package com.salex.creational.singleton;

/**
 * Singleton (Одиночка) - порождающий шаблон проектирования.
 * Гарантирует, что класс имеет только один экземпляр и предоставляет
 * к нему глобальную точку доступа.
 */
public class Singleton {

    private static Singleton instance = null;
    private static final Object mutex = new Object();

    private Singleton() {
        System.out.println("Created a new instance");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (mutex) {
                instance = (instance == null) ? new Singleton() : instance;
            }
        }
        System.out.println("Got instance");
        return instance;
    }

}

/** Initialization-on-demand holder idiom
 * Реализация идиомы основана на фазе инициализации выполнения в виртуальной машине Java (JVM), как указано в
 * спецификации языка Java (JLS). Когда класс Singleton загружается JVM, класс проходит инициализацию.
 * Поскольку класс не имеет статических переменных для инициализации, инициализация завершается тривиально.
 * Статическое определение класса LazyHolder внутри него не инициализируется, пока JVM не определит, что LazyHolder
 * должен быть выполнен. Статический класс LazyHolder выполняется только тогда, когда статический метод getInstance
 * вызывается для класса Singleton, и в первый раз, когда это происходит, JVM загрузит и инициализирует класс LazyHolder.
 * Инициализация класса LazyHolder приводит к инициализации статической переменной INSTANCE путем выполнения (закрытого)
 * конструктора для внешнего класса Singleton. Поскольку JLS гарантирует, что фаза инициализации класса будет
 * последовательной, т. е. неконкурентной, в статическом методе getInstance во время загрузки и инициализации не
 * требуется никакой дальнейшей синхронизации. И поскольку фаза инициализации записывает статическую переменную INSTANCE
 * в последовательной операции, все последующие конкурирующие вызовы getInstance вернут тот же правильно
 * инициализированный INSTANCE без дополнительных накладных расходов на синхронизацию.
 * 
 * public class Singleton {
 *     private Singleton() {}
 *
 *     private static class LazyHolder {
 *         static final Singleton INSTANCE = new Singleton();
 *     }
 *
 *     public static Singleton getInstance() {
 *         return LazyHolder.INSTANCE;
 *     }
 * }
 */