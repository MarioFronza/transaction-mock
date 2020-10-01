package com.github.transactionmock.transactions.generators;

import com.github.transactionmock.transactions.Transaction;

import java.util.List;

public interface TransactionGenerator {

    List<Transaction> generateTransactions(int id, int month, int year);

}
