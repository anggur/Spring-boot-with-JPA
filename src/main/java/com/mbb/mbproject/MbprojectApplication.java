package com.mbb.mbproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MbprojectApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(MbprojectApplication.class, args);
    }
    
}
