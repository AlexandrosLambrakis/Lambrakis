package models.assignments;

import java.time.LocalDate;

public final class IndividualProject extends Assignment {
    private IndividualProject(String title, String description, LocalDate subDateTime, int oralMark, int totalMark) {
        super(title, description, subDateTime, oralMark, totalMark);
    }

    public static IndividualProject build(String title, String description, LocalDate subDateTime, int oralMark, int totalMark) {
        return new IndividualProject(title, description, subDateTime, oralMark, totalMark);
    }
}