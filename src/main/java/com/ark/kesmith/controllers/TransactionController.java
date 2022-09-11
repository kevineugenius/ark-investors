package com.ark.kesmith.controllers;

import com.ark.kesmith.models.Transaction;
import com.ark.kesmith.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/transaction")
@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/add")
    public void addTransaction(@RequestBody Transaction transaction) {
        System.out.println("Investor service returned: " + transactionService.addTransaction(transaction));
    }
}
