package com.salex.structural.decorator;

public class ServiceDecorator extends Decorator {


    public ServiceDecorator(Service service) {
        super(service);
    }

    @Override
    public void bar() {
        System.out.println("Log start time");
        service.bar();
        System.out.println("Log end time");
    }
}
