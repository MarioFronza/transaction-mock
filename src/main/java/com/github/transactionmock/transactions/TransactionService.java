package com.github.transactionmock.transactions;

import com.github.transactionmock.exceptions.ApiException;
import com.github.transactionmock.transactions.generators.FakeTransactionGenerator;
import com.github.transactionmock.transactions.validators.ParamsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private ParamsValidator paramsValidator;
    @Autowired
    private FakeTransactionGenerator fakeTransactionGenerator;

    public List<Transaction> getAllTransactions(int id, int month, int year) throws ApiException {
        paramsValidator.validateId(id);
        paramsValidator.validateMonth(month);
        return fakeTransactionGenerator.generateTransactions(id, month, year);
    }


}
