package com.ark.kesmith.integration;

import com.ark.kesmith.controllers.TransactionController;
import com.ark.kesmith.repositories.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransactionIntegrationTest {
    @Autowired
    private TransactionController transactionController;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void testAdd() throws Exception {

    }
}
