package org.example.NplusOneProblem.repository;

import org.example.NplusOneProblem.entity.CompanyEntity;
import org.example.NplusOneProblem.entity.EmployeeEntity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;

@SpringBootTest
class CompanyRepositoryTest {

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
        "postgres:16-alpine"
    );
    @Autowired
    private CompanyRepository companyRepository;

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Test
    public void test() {
        CompanyEntity company = CompanyEntity.builder()
            .id(1L).name("Company")
            .build();
        EmployeeEntity employee1 = EmployeeEntity.builder()
            .id(3L).fullName("employee1").company(company)
            .build();
        EmployeeEntity employee2 = EmployeeEntity.builder()
            .id(4L).fullName("employee2").company(company)
            .build();
        company.setEmployees(List.of(employee1, employee2));

        companyRepository.save(company);

        companyRepository.findAll(); // N + 1 problem
        /*
        You'll see in console next output:

[Hibernate]
    select
        ce1_0.id,
        ce1_0.name
    from
        company ce1_0
[Hibernate] <--- for every company additional SELECT is called
    select
        e1_0.company_id,
        e1_0.id,
        e1_0.full_name
    from
        employee e1_0
    where
        e1_0.company_id=?

        */

        System.out.println();
    }

}