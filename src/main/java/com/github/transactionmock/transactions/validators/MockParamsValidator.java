package com.github.transactionmock.transactions.validators;

import com.github.transactionmock.exceptions.ApiException;
import org.springframework.stereotype.Component;

import static com.github.transactionmock.utils.Constants.*;

@Component
public class MockParamsValidator implements ParamsValidator {

    @Override
    public void validateId(int id) throws ApiException {
        if (id < MIN_ID || id > MAX_ID) {
            throw new ApiException("Invalid id value");
        }
    }

    @Override
    public void validateMonth(int month) throws ApiException {
        if (month < MIN_MONTH || month > MAX_MONTH) {
            throw new ApiException("Invalid id value");
        }
    }

}
