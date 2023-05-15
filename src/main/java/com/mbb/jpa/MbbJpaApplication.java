package com.mbb.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MbbJpaApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(MbbJpaApplication.class, args);
    }
    
}
