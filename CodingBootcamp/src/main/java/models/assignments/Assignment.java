package models.assignments;

import java.time.LocalDate;

public abstract class Assignment {
    private final String title;
    private final String description;
    private final LocalDate subDateTime;
    private final int oralMark;
    private final int totalMark;

    public Assignment(String title, String description, LocalDate subDateTime, int oralMark, int totalMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    public String getTitle() {
        return title;
    }

    public String customView(String tabs) {
        return "Assignment:\n" +
                tabs+"title: '" + title + '\'' +
                ",\n"+tabs+"description: '" + description + '\'' +
                ",\n"+tabs+"subDateTime: " + subDateTime +
                ",\n"+tabs+"oralMark: " + oralMark +
                ",\n"+tabs+"totalMark: " + totalMark;
    }

    @Override
    public String toString() {
        return "Assignment:\n" +
                "\t\ttitle: '" + title + '\'' +
                ",\n\t\tdescription: '" + description + '\'' +
                ",\n\t\tsubDateTime: " + subDateTime +
                ",\n\t\toralMark: " + oralMark +
                ",\n\t\ttotalMark: " + totalMark;
    }
}
