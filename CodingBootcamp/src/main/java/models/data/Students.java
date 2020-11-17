package models.data;

import java.time.LocalDate;

public enum Students {
    STUDENT_0(0,"Alexandros", "Lmprakis",    LocalDate.of(1997, 1, 28), 2000),
    STUDENT_1(1,"Alexand",    "Lampakis",    LocalDate.of(1996, 2, 18), 2500),
    STUDENT_2(2,"Alexa",      "Lamprkis",    LocalDate.of(1994, 6, 28), 2000),
    STUDENT_3(3,"Alexans",    "Lampris",     LocalDate.of(1995, 4, 28), 2000),
    STUDENT_4(4,"Alexaos",    "Lamakis",     LocalDate.of(1999, 2, 28), 2000),
    STUDENT_5(5,"Alexans",    "Laprakis",    LocalDate.of(2000, 3, 28), 2000)
    ;
    private final int index;
    private final String name;
    private final String surname;
    private final LocalDate dateBorn;
    private final int tuitionFees;

    public int getIndex() {
        return index;
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateBorn() {
        return dateBorn;
    }

    Students(int index, String name, String surname, LocalDate date, int tuitionFees) {
        this.index = index;
        this.name = name;
        this.surname = surname;
        this.dateBorn = date;
        this.tuitionFees = tuitionFees;
    }
}