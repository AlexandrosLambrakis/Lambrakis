package models.data.indexes;

import java.util.List;

import static java.util.Arrays.asList;
import static models.data.Courses.*;
import static models.data.Students.*;

public enum CourseStudentIndex {
    JAVA_FULL_STUDENTS   (COURSE_0.getIndex(), asList(STUDENT_1.getIndex(),   STUDENT_2.getIndex())),
    JAVA_PART_STUDENTS   (COURSE_1.getIndex(), asList(STUDENT_1.getIndex(),   STUDENT_5.getIndex())),
    CSHARP_FULL_STUDENTS (COURSE_2.getIndex(), asList(STUDENT_2.getIndex(),   STUDENT_5.getIndex())),
    CSHARP_PART_STUDENTS (COURSE_3.getIndex(), asList(STUDENT_4.getIndex(),   STUDENT_3.getIndex())),
    PHP_FULL_STUDENTS    (COURSE_4.getIndex(), asList(STUDENT_2.getIndex(),   STUDENT_4.getIndex())),
    PHP_PART_STUDENTS    (COURSE_5.getIndex(), asList(STUDENT_3.getIndex(),   STUDENT_4.getIndex()));

    private final int courseIndex;
    private final List<Integer> studentIndexes;

    public int getCourseIndex() {
        return courseIndex;
    }

    public List<Integer> getStudentIndexes() {
        return studentIndexes;
    }

    CourseStudentIndex(int courseIndex, List<Integer> studentIndexes) {
        this.courseIndex = courseIndex;
        this.studentIndexes = studentIndexes;
    }
}