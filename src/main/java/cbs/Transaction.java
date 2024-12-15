package cbs;

import java.sql.Timestamp;

import cbs.enums.TransactionStatus;
import cbs.enums.TransactionType;

public class Transaction extends TransactionDetails {
    private TransactionType type;
    private int recipient_id;

    public Transaction(int id, int account, Timestamp transactionDate, double amount, TransactionStatus status, TransactionType type) {
        super(id, account, transactionDate, amount, status);
        this.type = type;
    }
    public Transaction(int id, int account, Timestamp transactionDate, double amount, TransactionStatus status, TransactionType type, int recipient_id) {
        super(id, account, transactionDate, amount, status);
        this.type = type;
        this.recipient_id = recipient_id;
    }
    // Getting members
    public String get_type() {
        return this.type.name();
    }
    public int get_recipient_id() {
        return this.recipient_id;
    }
}
