package models.data;

public enum Trainers {
    TRAINER_0(0, "Kostas", "Lfscwo","Java"),
    TRAINER_1(1, "Kstas",  "Lkgs",  "Java"),
    TRAINER_2(2, "Kosas",  "Drooo", "C#"),
    TRAINER_3(3, "Kostas", "Pofm",  "C#"),
    TRAINER_4(4, "Kotas",  "Rgjs",  "PHP"),
    TRAINER_5(5, "Kosts",  "Ssfo",  "PHP")
    ;
    private final int index;
    private final String firstName;
    private final String lastName;
    private final String subject;

    public int getIndex() {
        return index;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSubject() {
        return subject;
    }

    Trainers(int index, String firstName, String lastName, String subject) {
        this.index = index;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }
}
