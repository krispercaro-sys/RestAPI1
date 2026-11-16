package com.spring.spring_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.hibernate.autoconfigure
        .HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure
        .DataSourceAutoConfiguration;

/**
 * Main entry point for the Spring REST application.
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
public class SpringRestApplication {

    /**
     * Starts the Spring Boot application.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class, args);
    }
}