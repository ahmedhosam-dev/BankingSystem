package cbs;

import cbs.enums.UserRole;
import cbs.auth.Authentication;

public class User extends Person{
    private UserRole role;
    private String password;

    // For createint new user 
    public User(int id, String name, String fullName, String email, String password, UserRole role) {
        super(id, name, fullName, email);
        this.password = password; 
        this.role = role;
    }

    // Getting members
    public UserRole get_role() {
        return this.role;
    }

    public String get_password() {
        return Authentication.hash_password(this.password);
    }

    // Methods
    @Override
    public String display() {
        return "User name: " + get_name() + "\nEmail: " + get_email() + "\nRole: " + get_role();
    }
}
