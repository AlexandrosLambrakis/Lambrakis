package models.assignments;

import java.time.LocalDate;

public final class GroupProject extends Assignment {
    private GroupProject(String title, String description, LocalDate subDateTime, int oralMark, int totalMark) {
        super(title, description, subDateTime, oralMark, totalMark);
    }

    public static GroupProject build(String title, String description, LocalDate subDateTime, int oralMark, int totalMark) {
        return new GroupProject(title, description, subDateTime, oralMark, totalMark);
    } 
}
