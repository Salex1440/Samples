package com.salex.behavioral.mediator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediatorTest {

    @Test
    public void test() {
        Customer customer = new Customer();
        Developer developer = new Developer();
        Tester tester = new Tester();
        Mediator managerMediator = new ManagerMediator(customer, developer, tester);

        customer.send("Есть заказ, надо сделать программу");
        developer.send("Программа готова, надо протестировать");
        tester.send("Программа протестирована и готова к продаже");
    }

}