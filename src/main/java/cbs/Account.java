package cbs;

import java.sql.Timestamp;

import cbs.enums.AccountStatus;

public class Account {
    private final int id;
    private Customer customer;
    private double balance;
    private AccountStatus status;
    private Timestamp createdAt; 
    private Timestamp updatedAt;

    private int customer_id;

    public Account(int id, Customer customer, double balance, AccountStatus status, Timestamp createdAt) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Account (int id, int customer_id, double balance, AccountStatus status, Timestamp createdAt) {
        this.id = id;
        this.customer_id = customer_id;
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

    public final int get_customer_id() {
        return this.customer_id;
    }

    public final double get_balance() {
        return this.balance;
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
    public String display() {
        return "Account Info:\nCustomer name: " + get_customer().get_name() + "\nBalance: " + get_balance() +
               "\nStatus: " + get_status() + "\nCreated at: " + get_created_date() + "\nUpdated at: " + get_last_updated_date();
    }
}
