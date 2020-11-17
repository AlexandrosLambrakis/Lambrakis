package models;

public class Trainer {
    private final String firstName;
    private final String lastName;
    private final String subject;

    public Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public static Trainer build(String firstName, String lastName, String subject) {
        return new Trainer(firstName, lastName, subject);
    }

    public String customView(String tabs) {
        return "Trainer:\n" +
                tabs+"firstName: '" + firstName + '\'' +
                ",\n"+tabs+"lastName: '" + lastName + '\'' +
                ",\n"+tabs+"subject: '" + subject + '\'';
    }

    @Override
    public String toString() {
        return "Trainer:\n" +
                "\tfirstName: '" + firstName + '\'' +
                ",\n\tlastName: '" + lastName + '\'' +
                ",\n\tsubject: '" + subject + '\'';
    }
}

