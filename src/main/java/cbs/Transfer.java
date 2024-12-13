package cbs;

import java.sql.Timestamp;

public class Transfer extends TransactionDetails {
    private Account recipient;

    public Transfer(int id, Account account, Timestamp transactionDate, double amount, TransactionStatus status, Account recipient) {
        super(id, account, transactionDate, amount, status);
        this.recipient = recipient;
    }

    // Getting members
    public Account get_recipient() {
        return this.recipient;
    }
}
