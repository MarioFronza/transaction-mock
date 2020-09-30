package com.github.transactionmock.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private List<Transaction> transactions;

    @Autowired
    public TransactionService() {
        this.transactions = new ArrayList<>();
        this.transactions.add(new Transaction(
                "descrição",
                123,
                1232,
                false));
    }

    public List<Transaction> getAllTransactions() {
        return this.transactions;
    }
}
