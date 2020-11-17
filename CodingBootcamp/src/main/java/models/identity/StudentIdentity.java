package models.identity;

import models.Student;
import models.subs.SubAssignment;
import models.subs.SubCourse;

public class StudentIdentity {
    private final Student student;
    private final SubCourse subCourse;
    private final SubAssignment subAssignment;

    public StudentIdentity(Student student, SubCourse subCourse, SubAssignment subAssignment) {
        this.student = student;
        this.subCourse = subCourse;
        this.subAssignment = subAssignment;
    }

    public static StudentIdentity build(Student student, SubCourse subCourse, SubAssignment subAssignment) {
        return new StudentIdentity(student, subCourse, subAssignment);
    }

    public static StudentIdentity build(Student student) {
        return new StudentIdentity(student, SubCourse.build(), SubAssignment.build());
    }

    public Student getStudent() {
        return student;
    }

    public SubCourse getSubCourse() {
        return subCourse;
    }

    public SubAssignment getSubAssignment() {
        return subAssignment;
    }

    public void viewAssignments() {
        subAssignment.viewSubscribable();
    }

    public void viewCourses() {
        subCourse.viewSubscribable();
    }
}
