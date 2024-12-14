package cbs;

import java.sql.Timestamp;

import cbs.enums.TransactionStatus;
import cbs.enums.TransactionType;

public class Transaction extends TransactionDetails{
    private TransactionType type;

    public Transaction(int id, Account account, Timestamp transactionDate, double amount, TransactionStatus status, TransactionType type) {
        super(id, account, transactionDate, amount, status);
        this.type = type;
    }

    public Transaction(int id, int account, Timestamp transactionDate, double amount, TransactionStatus status, TransactionType type) {
        super(id, account, transactionDate, amount, status);
        this.type = type;
    }
    // Getting members
    public String get_type() {
        return this.type.name();
    }
}
