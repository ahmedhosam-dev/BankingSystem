package cbs;

import java.sql.Timestamp;

enum TransactionType {
    DEPOSIT,
    WITHDRAW
}

public class Transaction extends TransactionDetails{
    private TransactionType type;

    public Transaction(int id, Account account, Timestamp transactionDate, double amount, TransactionStatus status, TransactionType type) {
        super(id, account, transactionDate, amount, status);
        this.type = type;
    }

    // Getting members
    public TransactionType get_type() {
        return this.type;
    }
}
