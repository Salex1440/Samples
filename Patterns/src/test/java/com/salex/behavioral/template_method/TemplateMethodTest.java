package com.salex.behavioral.template_method;

import org.junit.jupiter.api.Test;


class TemplateMethodTest {

    @Test
    public void test() {
        Person factoryWorker = new FactoryWorker();
        factoryWorker.workday();
        System.out.println();
        Person officeWorker = new OfficeWorker();
        officeWorker.workday();
    }

}