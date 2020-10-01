package com.github.transactionmock.transactions;

import com.github.transactionmock.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Validated
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}/transactions/{year}/{month}")
    public List<Transaction> getAll(
            @PathVariable int id,
            @PathVariable int year,
            @PathVariable int month) {
        try {
            return this.transactionService.getAllTransactions(id, month, year);
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        }

    }
}
