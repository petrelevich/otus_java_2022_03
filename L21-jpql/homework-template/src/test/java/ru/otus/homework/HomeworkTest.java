package ru.otus.homework;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.jdbc.spi.SqlStatementLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.crm.model.Client;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

class HomeworkTest {

    private StandardServiceRegistry serviceRegistry;
    private Metadata metadata;
    private SessionFactory sessionFactory;

    // Это надо раскомментировать, у выполненного ДЗ, все тесты должны проходить
    // Кроме удаления комментирования, тестовый класс менять нельзя
/*
    @BeforeEach
    public void setUp() {
        makeTestDependencies();
    }

    @AfterEach
    public void tearDown() {
        sessionFactory.close();
    }


    @Test
    public void testHomeworkRequirementsForTablesCount() {

        var tables = StreamSupport.stream(metadata.getDatabase().getNamespaces().spliterator(), false)
                .flatMap(namespace -> namespace.getTables().stream())
                .collect(Collectors.toList());
        assertThat(tables).hasSize(3);
    }

        @Test
    public void testHomeworkRequirementsForUpdatesCount() {
        applyCustomSqlStatementLogger(new SqlStatementLogger(true, false, false, 0) {
            @Override
            public void logStatement(String statement) {
                assertThat(statement).doesNotContain("update");
                super.logStatement(statement);
            }
        });

        var client = new Client(null, "Vasya", new Address(null, "AnyStreet"),
            List.of(new Phone(null, "13-555-22"), new Phone(null, "14-666-333")));
        try (var session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.persist(client);
            session.getTransaction().commit();

            session.clear();

            var loadedClient = session.find(Client.class, 1L).clone();
            assertThat(loadedClient)
                .usingRecursiveComparison()
                .isEqualTo(client);
        }
    }


    private void makeTestDependencies() {
        var cfg = new Configuration();

        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        cfg.setProperty("hibernate.connection.driver_class", "org.h2.Driver");

        cfg.setProperty("hibernate.connection.url", "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");

        cfg.setProperty("hibernate.connection.username", "sa");
        cfg.setProperty("hibernate.connection.password", "");

        cfg.setProperty("hibernate.show_sql", "true");
        cfg.setProperty("hibernate.format_sql", "false");
        cfg.setProperty("hibernate.generate_statistics", "true");

        cfg.setProperty("hibernate.hbm2ddl.auto", "create");
        cfg.setProperty("hibernate.enable_lazy_load_no_trans", "false");

        serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties()).build();


        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(Phone.class);
        metadataSources.addAnnotatedClass(Address.class);
        metadataSources.addAnnotatedClass(Client.class);
        metadata = metadataSources.getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    private void applyCustomSqlStatementLogger(SqlStatementLogger customSqlStatementLogger) {
        var jdbcServices = serviceRegistry.getService(JdbcServices.class);
        try {
            Field field = jdbcServices.getClass().getDeclaredField("sqlStatementLogger");
            field.setAccessible(true);
            field.set(jdbcServices, customSqlStatementLogger);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
}