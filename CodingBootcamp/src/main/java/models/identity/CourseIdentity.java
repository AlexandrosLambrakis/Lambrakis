package models.identity;

import models.courses.Course;
import models.subs.SubAssignment;
import models.subs.SubStudent;
import models.subs.SubTrainer;

public class CourseIdentity  {
    private final Course course;
    private final SubAssignment subAssignment;
    private final SubStudent subStudent;
    private final SubTrainer subTrainer;

    public CourseIdentity(Course course, SubAssignment subAssignment, SubStudent subStudent, SubTrainer subTrainer) {
        this.course = course;
        this.subAssignment = subAssignment;
        this.subStudent = subStudent;
        this.subTrainer = subTrainer;
    }

    public Course getCourse() {
        return course;
    }

    public SubAssignment getSubCourseAssignment() {
        return subAssignment;
    }

    public SubStudent getSubCourseStudent() {
        return subStudent;
    }

    public SubTrainer getSubCourseTrainer() {
        return subTrainer;
    }

    public static CourseIdentity build(Course course, SubAssignment subAssignment, SubStudent subStudent, SubTrainer subTrainer) {
        return new CourseIdentity(course, subAssignment, subStudent, subTrainer);
    }

    public static CourseIdentity build(Course course) {
        return new CourseIdentity(course, SubAssignment.build(), SubStudent.build(), SubTrainer.build());
    }

    @Override
    public String toString() {
        return "SubCourse{" +
                "course=" + course +
                ", subCourseAssignment=" + subAssignment +
                ", subCourseStudent=" + subStudent +
                ", subCourseTrainer=" + subTrainer +
                '}';
    }
}
