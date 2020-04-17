package com.test.valid.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("com.test.valid.dao")
@EntityScan("com.test.valid.entity")
@ComponentScan("com.test.valid")
public class TestApplication {

    private static final Logger logger = LoggerFactory.getLogger(TestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
