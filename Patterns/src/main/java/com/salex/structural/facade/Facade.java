package com.salex.structural.facade;

/**
 * Фасад (Facade) — структурный шаблон проектирования, позволяющий скрыть сложность системы путём сведения всех
 * возможных внешних вызовов к одному объекту, делегирующему их соответствующим объектам системы.
 */
public class Facade {
    private final Service1 service1;
    private final Service2 service2;

    public Facade(Service1 service1, Service2 service2) {
        this.service1 = service1;
        this.service2 = service2;
    }

    public void operate() {
        service1.operate();
        service2.operate();
    }
}
