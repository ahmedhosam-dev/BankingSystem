package cbs;

import java.sql.SQLException;
import java.sql.Timestamp;

import cbs.db.AccountOperation;
import cbs.db.TransactionOperation;
import cbs.enums.AccountStatus;
import cbs.enums.TransactionStatus;
import cbs.enums.TransactionType;

public class Account {
    private final int id;
    private int customer_id;
    private double balance;
    private AccountStatus status;
    private Timestamp createdAt; 
    private Timestamp updatedAt;


    public Account (int id, int customer_id, double balance, AccountStatus status, Timestamp createdAt) {
        this.id = id;
        this.customer_id = customer_id;
        this.balance = balance;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Account (int id, int customer_id, double balance, AccountStatus status, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.customer_id = customer_id;
        this.balance = balance;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getting members
    public final int get_id() {
        return this.id;
    }

    public final int get_customer_id() {
        return this.customer_id;
    }

    public final double get_balance() {
        return this.balance;
    }

    private final boolean set_balance(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    private final boolean unset_balance(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public final String get_status() {
        return this.status.name();
    }

    public final Timestamp get_created_date() {
        return this.createdAt;
    }

    public final Timestamp get_last_updated_date() {
        return this.updatedAt;
    }

    // Methods
    public final void deposit(double amount) throws SQLException {
        TransactionStatus transactionStatus;
        if (set_balance(amount)){
            transactionStatus = TransactionStatus.SUCCESS;
        } else {
            transactionStatus = TransactionStatus.FAILED;
        }
        Transaction transaction = new Transaction(0, get_id(), get_created_date(), amount, transactionStatus, TransactionType.DEPOSIT);
        TransactionOperation.insert(transaction);
    }

    public final void withdraw(double amount) throws SQLException {
        TransactionStatus transactionStatus;
        if (unset_balance(amount)) {
            transactionStatus = TransactionStatus.SUCCESS;
        } else {
            transactionStatus = TransactionStatus.FAILED;
        }
        Transaction transaction = new Transaction(0, get_id(), new Timestamp(System.currentTimeMillis()), amount, transactionStatus, TransactionType.WITHDRAW);
        TransactionOperation.insert(transaction);
    }

    public final void transfer(double amount, Account to) throws SQLException {
        TransactionStatus transactionStatus;
        if (unset_balance(amount) && to != null) {
            transactionStatus = TransactionStatus.SUCCESS;
        } else {
            transactionStatus = TransactionStatus.FAILED;
        }

        Transaction transaction = new Transaction(0, get_id(), new Timestamp(System.currentTimeMillis()), amount, transactionStatus, TransactionType.TRANSFER, to.get_id());
        to.set_balance(amount);
        TransactionOperation.insert(transaction);
    }

    public final void save_changes() throws SQLException {
        AccountOperation.update(this);
    }

    public String display() {
        return "Account Info:\nCustomer ID: " + get_customer_id() + "\nBalance: " + get_balance() +
               "\nStatus: " + get_status() + "\nCreated at: " + get_created_date() + "\nUpdated at: " + get_last_updated_date();
    }
}
