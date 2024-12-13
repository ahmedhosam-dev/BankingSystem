package cbs;

public abstract class Person {
    private final int id;
    private String name;
    private String fullName;
    private String email;

    public Person(int id, String name, String fullName, String email) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.email = email;
    }

    // Getting members
    public final int get_id() {
        return this.id;
    }

    public final String get_name() {
        return this.name;
    }

    public final String get_full_name() {
        return this.fullName;
    }
    public final String get_email() {
        return this.email;
    }

    // Methods
    public abstract String display();
}
