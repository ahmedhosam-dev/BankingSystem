package cbs;

import cbs.enums.CustomerStatus;

public class Customer extends Person {
    private String birthday;
    private String phoneNumber;
    private String address;
    private CustomerStatus status; 

    public Customer(int id, String name, String fullName, String email, String birthday, String phoneNumber, String address, CustomerStatus status) {
        super(id, name, fullName, email);
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
    }

    // Getting members
    public final String get_birthday() {
        return this.birthday;
    }
    public final String get_phone_number() {
        return this.phoneNumber;
    }
    public final String get_address() {
        return this.address;
    }
    public final String get_status() {
        return this.status.name();
    }

    // Methods
    @Override
    public String display() {
        return "Cusomter name: " + get_name() + "\nEmail: " + get_email() +
               "\nPhone: " + get_phone_number() + "\nStatus: " + get_status();
    }

    @Override
    public String toString() {
        return "Id: " + get_id() + "\nName: " + get_name() + "\nEmail: " + get_email() + "\nPhone: " + get_phone_number() + "\nAddress: " + get_address() + "\nStatus: " + get_status();
    }
}
