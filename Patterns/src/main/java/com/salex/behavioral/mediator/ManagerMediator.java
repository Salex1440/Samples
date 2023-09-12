package com.salex.behavioral.mediator;

public class ManagerMediator implements Mediator {
    private final Customer customer;
    private final Developer developer;
    private final Tester tester;

    public ManagerMediator(Customer customer, Developer developer, Tester tester) {
        this.customer = customer;
        this.customer.setMediator(this);
        this.developer = developer;
        this.developer.setMediator(this);
        this.tester = tester;
        this.tester.setMediator(this);
    }

    @Override
    public void send(String msg, Colleague from) {
        if (from.getClass() == Customer.class) {
            developer.notify(msg);
        } else if (from.getClass() == Developer.class) {
            tester.notify(msg);
        } else if (from.getClass() == Tester.class) {
            customer.notify(msg);
        }
    }
}
