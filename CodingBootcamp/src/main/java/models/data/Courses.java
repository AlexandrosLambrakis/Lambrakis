package models.data;

import models.courses.CourseTimeType;

import java.time.LocalDate;

public enum Courses {
    COURSE_0(0, "CB-01", "Java",  CourseTimeType.FULLTIME,  LocalDate.of(2020, 1, 10),  LocalDate.of(2020, 3, 10)),
    COURSE_1(1, "CB-02", "Java",  CourseTimeType.PARTTIME,  LocalDate.of(2020, 1, 1),   LocalDate.of(2020, 7, 1)),
    COURSE_2(2, "CB-03", "C#",    CourseTimeType.FULLTIME,  LocalDate.of(2020, 1, 10),  LocalDate.of(2020, 3, 10)),
    COURSE_3(3, "CB-04", "C#",    CourseTimeType.PARTTIME,  LocalDate.of(2020, 1, 1),   LocalDate.of(2020, 7, 1)),
    COURSE_4(4, "CB-05", "PHP",   CourseTimeType.FULLTIME,  LocalDate.of(2020, 1, 10),  LocalDate.of(2020, 3, 10)),
    COURSE_5(5, "CB-06", "PHP",   CourseTimeType.PARTTIME,  LocalDate.of(2020, 1, 1),   LocalDate.of(2020, 7, 1))
    ;
    private final int index;
    private final String title;
    private final String stream;
    private final CourseTimeType courseTimeType;
    private final LocalDate starting_date;
    private final LocalDate ending_date;

    public int getIndex() {
        return index;
    }

    public String getTitle() {
        return title;
    }

    public String getStream() {
        return stream;
    }

    public CourseTimeType getCourseTimeType() {
        return courseTimeType;
    }

    public LocalDate getStarting_date() {
        return starting_date;
    }

    public LocalDate getEnding_date() {
        return ending_date;
    }

    Courses(int index, String title, String stream, CourseTimeType courseTimeType, LocalDate starting_date, LocalDate ending_date) {
        this.index = index;
        this.title = title;
        this.stream = stream;
        this.courseTimeType = courseTimeType;
        this.starting_date = starting_date;
        this.ending_date = ending_date;
    }
}
