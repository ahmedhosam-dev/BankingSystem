package cbs;

public abstract class Person implements PersonStuffInterface {
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
    @Override
    public final int get_id() {
        return this.id;
    }

    @Override
    public final String get_name() {
        return this.name;
    }

    @Override
    public final String get_full_name() {
        return this.fullName;
    }

    @Override
    public final String get_email() {
        return this.email;
    }

    // Methods
    @Override
    public abstract String display();
}
