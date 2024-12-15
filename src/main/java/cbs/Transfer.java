package cbs;

import java.sql.Timestamp;

import cbs.enums.TransactionStatus;

public class Transfer extends TransactionDetails {
    private int recipient_id;

    public Transfer(int id, int account, Timestamp transactionDate, double amount, TransactionStatus status, int recipient) {
        super(id, account, transactionDate, amount, status);
        this.recipient_id = recipient;
    }

    // Getting members
    public int get_recipient_id() {
        return this.recipient_id;
    }
}
