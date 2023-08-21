package com.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QualifierMain {

    public static void main(String[] args) {
        SpringApplication.run(QualifierMain.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            @Qualifier("FooImpl1") Foo fooBean1,
            @Qualifier("FooImpl2") Foo fooBean2,
            Foo fooBean3) {
        return args -> {
            fooBean1.bar();
            fooBean2.bar();
            fooBean3.bar();
        };
    }

}
