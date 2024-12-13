package cbs;

import java.sql.Timestamp;

enum TransactionStatus {
    SUCCESS,
    FAILED,
    PENDING
}

public abstract class TransactionDetails {
    private final int id;
    private Account account;
    private Timestamp transactionDate;
    private double amount;
    private TransactionStatus status;

    public TransactionDetails(int id, Account account, Timestamp transactionDate, double amount, TransactionStatus status) {
        this.id = id;
        this.account = account;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.status = status;
    }

    // Getting members
    public final int get_id() {
        return this.id;
    }

    public final Account get_account() {
        return this.account;
    }

    public final Timestamp get_transaction_date() {
        return this.transactionDate;
    }

    public final double get_amount() {
        return this.amount;
    }

    public final TransactionStatus get_status() {
        return this.status;
    }
}
