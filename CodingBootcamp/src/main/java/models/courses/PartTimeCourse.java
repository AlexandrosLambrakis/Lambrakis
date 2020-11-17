package models.courses;


import java.time.LocalDate;

public final class PartTimeCourse extends Course {
    private PartTimeCourse(String title, String stream, CourseTimeType type, LocalDate start_date, LocalDate end_date) {
        super(title, stream, type, start_date, end_date);
    }

    public static PartTimeCourse build(String title, String stream, CourseTimeType type, LocalDate start_date,
            LocalDate end_date) {
        return new PartTimeCourse(title, stream, type, start_date, end_date);
    }
}
