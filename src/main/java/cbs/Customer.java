package cbs;

enum CustomerStatus {
    ACTIVE,
    INACTIVE,
    FROZEN
}

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
    public final CustomerStatus get_status() {
        return this.status;
    }

    // Methods
    @Override
    public String display() {
        return "Cusomter name: " + get_name() + "\nEmail: " + get_email() +
               "\nPhone: " + get_phone_number() + "\nStatus: " + get_status();
    }
}
