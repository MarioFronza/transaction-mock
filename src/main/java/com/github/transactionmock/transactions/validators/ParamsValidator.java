package com.github.transactionmock.transactions.validators;

import com.github.transactionmock.exceptions.ApiException;

public interface ParamsValidator {

    void validateId(int id) throws ApiException;

    void validateMonth(int month) throws ApiException;

}
