package cbs;

enum UserRole {
    ADMIN,
    EMPLOYEE
}

class User extends Person{
    private UserRole role;
    private String password;

    public User(int id, String name, String fullName, String email, String password, UserRole role) {
        super(id, name, fullName, email);
        this.password = password; // Hash function
        this.role = role;
    }

    // Getting members
    public UserRole get_role() {
        return this.role;
    }

    protected String get_password() {
        return this.password;
    }

    // Methods
    @Override
    public String display() {
        return "User name: " + get_name() + "\nEmail: " + get_email() + "\nRole: " + get_role();
    }
}
