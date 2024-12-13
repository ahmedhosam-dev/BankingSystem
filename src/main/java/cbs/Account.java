package cbs;

import java.sql.Timestamp;

enum AccountStatus {
    ACITVE,
    FROZEN,
    CLOSE
}

public class Account {
    private final int id;
    private Customer customer;
    private double balance;
    private AccountStatus status;
    private Timestamp createdAt; 
    private Timestamp updatedAt;

    public Account(int id, Customer customer, double balance, AccountStatus status, Timestamp createdAt) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getting members
    public final int get_id() {
        return this.id;
    }

    public final Customer get_customer() {
        return this.customer;
    }

    public final double get_balance() {
        return this.balance;
    }

    public final AccountStatus get_status() {
        return this.status;
    }

    public final Timestamp get_created_date() {
        return this.createdAt;
    }

    public final Timestamp get_last_updated_date() {
        return this.updatedAt;
    }

    // Methods
    public String display() {
        return "Account Info:\nCustomer name: " + get_customer().get_name() + "\nBalance: " + get_balance() +
               "\nStatus: " + get_status() + "\nCreated at: " + get_created_date() + "\nUpdated at: " + get_last_updated_date();
    }
}
