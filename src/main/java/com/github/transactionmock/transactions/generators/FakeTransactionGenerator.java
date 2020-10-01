package com.github.transactionmock.transactions.generators;

import com.github.transactionmock.transactions.Transaction;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.github.transactionmock.utils.Constants.*;

@Component
public class FakeTransactionGenerator implements TransactionGenerator {

    private List<Transaction> transactions;
    private Random generator;
    private int month;
    private int year;
    private boolean alreadyDuplicated;

    @Override
    public List<Transaction> generateTransactions(int id, int month, int year) {
        this.transactions = new ArrayList<>();
        this.alreadyDuplicated = false;
        this.month = month;
        this.year = year;
        this.generator = new Random(id + month + year);
        int numberOfTransactions = this.generator.nextInt(MAX_MONTH - MIN_MONTH) + MIN_MONTH;
        for (int i = 0; i < numberOfTransactions; i++) {
            createTransaction();
        }
        return this.transactions;
    }

    private void createTransaction() {
        Transaction transaction = new Transaction(
                generateDescription(),
                generateDate(),
                generateValue(),
                false
        );
      checkDuplicatedAndAddTransaction(transaction);
    }

    private void checkDuplicatedAndAddTransaction(Transaction transaction){
          if(month % 2 == 0 && !alreadyDuplicated){
            this.transactions.add(transaction);
            alreadyDuplicated = true;
        }
        setDuplicated(transaction);
        this.transactions.add(transaction);
    }

    private String generateDescription() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = this.generator.nextInt(MAX_DESCRIPTION - MIN_DESCRIPTION) + MIN_DESCRIPTION;
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (this.generator.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    private long generateDate() {
        YearMonth yearMonthObject = YearMonth.of(year, month);
        int minDate = (int) LocalDate.of(year, Month.values()[month - 1], 1).toEpochDay();
        int maxDate = (int) LocalDate.of(year, month, yearMonthObject.lengthOfMonth()).toEpochDay();
        return this.generator.nextInt(maxDate - minDate) + minDate;
    }

    private int generateValue() {
        return this.generator.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE;
    }

    private void setDuplicated(Transaction currentTransaction) {
        if (transactions.contains(currentTransaction)) {
            currentTransaction.setDuplicated(true);
        }
    }

}
