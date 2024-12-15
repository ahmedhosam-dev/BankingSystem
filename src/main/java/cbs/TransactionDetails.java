package cbs;

import java.sql.Timestamp;

import cbs.enums.TransactionStatus;

public abstract class TransactionDetails {
    private final int id;
    private int account_id;
    private Timestamp transactionDate;
    private double amount;
    private TransactionStatus status;

    public TransactionDetails(int id, int account, Timestamp transactionDate, double amount, TransactionStatus status) {
        this.id = id;
        this.account_id = account;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.status = status;
    }

    // Getting members
    public final int get_id() {
        return this.id;
    }

    public final int get_account_id() {
        return this.account_id;
    }

    public final Timestamp get_transaction_date() {
        return this.transactionDate;
    }

    public final double get_amount() {
        return this.amount;
    }

    public final String get_status() {
        return this.status.name();
    }
}
