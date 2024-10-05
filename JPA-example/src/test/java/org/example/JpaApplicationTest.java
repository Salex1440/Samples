package org.example;

import jakarta.persistence.EntityManager;
import org.example.entity.TableA;
import org.example.entity.TableB;
import org.example.entity.TableC;
import org.example.entity2.A;
import org.example.entity2.B;
import org.example.entity2.C;
import org.example.repo.TableARepo;
import org.example.repo.TableBRepo;
import org.example.repo.TableCRepo;
import org.example.repo2.ARepo;
import org.example.repo2.BRepo;
import org.example.repo2.CRepo;
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
    @Autowired
    private EntityManager em;
    @Autowired
    private TableARepo tableARepo;
    @Autowired
    private TableBRepo tableBRepo;
    @Autowired
    private TableCRepo tableCRepo;
    @Autowired
    private ARepo aRepo;
    @Autowired
    private BRepo bRepo;
    @Autowired
    private CRepo cRepo;

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

    @BeforeEach
    void setUp() {
        tableARepo.deleteAll();
        tableBRepo.deleteAll();
        tableCRepo.deleteAll();
    }

    @Test
    void testJpa() {
        TableA a = new TableA(1L, "a");
        TableA a2 = new TableA(2L, "a2");
        TableB b = new TableB(2L, "b");
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

    @Test
    void testSOF() {
        A a = new A(1L, null);
        aRepo.save(a);
        B b = new B(2L, null);
        bRepo.save(b);
        C c = new C(3L, null);
        cRepo.save(c);
        a.setB(b);
        b.setC(c);
        c.setA(a);

        A save = aRepo.save(a);
        B save2 = bRepo.save(b);
        C save3 = cRepo.save(c);

        System.out.println(save);
    }


}
