package com.github.transactionmock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TransactionMockApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionMockApplication.class, args);
    }

}
