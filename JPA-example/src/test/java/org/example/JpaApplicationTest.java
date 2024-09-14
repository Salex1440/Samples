package org.example;

import jakarta.persistence.EntityManager;
import junit.framework.TestCase;
import org.example.entity.AB;
import org.example.entity.TableA;
import org.example.entity.TableB;
import org.example.entity.TableC;
import org.example.repo.TableARepo;
import org.example.repo.TableBRepo;
import org.example.repo.TableCRepo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest
public class JpaApplicationTest {

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
        "postgres:16-alpine"
    );

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

    @Autowired
    private EntityManager em;

    @Autowired
    private TableARepo tableARepo;

    @Autowired
    private TableBRepo tableBRepo;

    @Autowired
    private TableCRepo tableCRepo;

    @BeforeEach
    void setUp() {
        tableARepo.deleteAll();
        tableBRepo.deleteAll();
        tableCRepo.deleteAll();
    }

    @Test
    void testJpa() {
        TableA a = new TableA(1L);
        TableA a2 = new TableA(2L);
        TableB b = new TableB(2L);
        TableC c1 = new TableC(1L, a);
        TableC c2 = new TableC(2L, b);
        TableC c3 = new TableC(3L, a2);

        tableARepo.save(a);
        tableARepo.save(a2);
        tableBRepo.save(b);
        tableCRepo.save(c1);
        tableCRepo.save(c2);

        System.out.println();
    }


}
