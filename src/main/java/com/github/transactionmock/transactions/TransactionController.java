package com.github.transactionmock.transactions;

import com.github.transactionmock.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity getAll(
            @PathVariable int id,
            @PathVariable int year,
            @PathVariable int month) {
        try {
            return new ResponseEntity<>(this.transactionService.getAllTransactions(id, month, year), HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
        }

    }
}
