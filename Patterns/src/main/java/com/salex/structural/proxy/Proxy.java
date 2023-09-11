package com.salex.structural.proxy;

/**
 * Заместитель (Proxy) — структурный шаблон проектирования, который предоставляет объект,
 * контролирующий доступ к другому объекту, перехватывая все вызовы (выполняет функцию контейнера).
 */
public class Proxy implements Subject {

    private SubjectImpl subject = null;

    @Override
    public void operate() {
        if (subject == null) {
            subject = new SubjectImpl();
        }
        subject.operate();
    }
}
