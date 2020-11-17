package models.courses;

import java.time.LocalDate;

public final class FullTimeCourse extends Course {

    private FullTimeCourse(String title, String stream, CourseTimeType type, LocalDate start_date, LocalDate end_date) {
        super(title, stream, type, start_date, end_date);
    }

    public static FullTimeCourse build(String title, String stream, CourseTimeType type, LocalDate start_date,
            LocalDate end_date) {
        return new FullTimeCourse(title, stream, type, start_date, end_date);
    }
}
