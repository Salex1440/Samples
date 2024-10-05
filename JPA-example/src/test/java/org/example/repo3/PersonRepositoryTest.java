package org.example.repo3;

import jakarta.persistence.EntityManager;
import org.example.entity3.AddressEntity;
import org.example.entity3.PersonEntity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Optional;

@SpringBootTest
class PersonRepositoryTest {

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
        "postgres:16-alpine"
    );

    @Autowired
    private EntityManager em;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

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
        AddressEntity addressEntity = new AddressEntity(1L, "city", "street");
        addressRepository.save(addressEntity);
        PersonEntity personEntity = new PersonEntity(1L, "name", addressEntity);
        personRepository.save(personEntity);

        PersonEntity person = personRepository.findById(1L).get(); // no join
        PersonEntity person2 = personRepository.findWithAddressById(1L).get(); // left inner join
        AddressEntity address = addressRepository.findById(1L).get();

        System.out.println();
    }

}