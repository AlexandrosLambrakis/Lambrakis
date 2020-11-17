package models.courses;

import java.time.LocalDate;

public abstract class Course {

    private final String title;
    private final String stream;
    private final CourseTimeType type;
    private final LocalDate start_date;
    private final LocalDate end_date;

    public Course(String title, String stream, CourseTimeType type, LocalDate start_date, LocalDate end_date) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getTitle() {
        return title;
    }

    public String getStream() {
        return stream;
    }

    public CourseTimeType getType() {
        return type;
    }

    public String customView(String tabs) {
        return "Course:\n" +
                tabs + "title: '" + title + '\'' +
                ",\n"+tabs+"stream: '" + stream + '\'' +
                ",\n"+tabs+"type: " + type +
                ",\n"+tabs+"start_date: " + start_date +
                ",\n"+tabs+"end_date: " + end_date;
    }

    @Override
    public String toString() {
        return "Course:\n" +
                "\ttitle: '" + title + '\'' +
                ",\n\tstream: '" + stream + '\'' +
                ",\n\ttype: " + type +
                ",\n\tstart_date: " + start_date +
                ",\n\tend_date: " + end_date;
    }
}
