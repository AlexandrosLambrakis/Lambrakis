package models;

import java.time.LocalDate;

public class Student {
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final int tuitionFees;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, int tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public static Student build(String firstName, String lastName, LocalDate dateOfBirth, int tuitionFees){
        return new Student(firstName, lastName, dateOfBirth, tuitionFees);
    }

    public String customView(String tabs) {
        return "Student:\n" +
                tabs+"firstName: '" + firstName + '\'' +
                ",\n"+tabs+"lastName: '" + lastName + '\'' +
                ",\n"+tabs+"dateOfBirth: " + dateOfBirth +
                ",\n"+tabs+"tuitionFees: " + tuitionFees;
    }

    @Override
    public String toString() {
        return "Student:\n" +
                "\tfirstName: '" + firstName + '\'' +
                ",\n\tlastName: '" + lastName + '\'' +
                ",\n\tdateOfBirth: " + dateOfBirth +
                ",\n\ttuitionFees: " + tuitionFees;
    }
}
