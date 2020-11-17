package models.data.indexes;


import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static models.data.Assignments.*;
import static models.data.Courses.*;

public enum CourseAssignmentIndex {
    JAVA_FULL_ASSIGNMENTS   (COURSE_0.getIndex(), asList(ASSIGNMENT_0.getIndex(), ASSIGNMENT_1.getIndex())),
    JAVA_PART_ASSIGNMENTS   (COURSE_1.getIndex(), asList(ASSIGNMENT_2.getIndex(), ASSIGNMENT_1.getIndex())),
    CSHARP_FULL_ASSIGNMENTS (COURSE_2.getIndex(), asList(ASSIGNMENT_3.getIndex(), ASSIGNMENT_4.getIndex())),
    CSHARP_PART_ASSIGNMENTS (COURSE_3.getIndex(), asList(ASSIGNMENT_5.getIndex(), ASSIGNMENT_4.getIndex())),
    PHP_FULL_ASSIGNMENTS    (COURSE_4.getIndex(), asList(ASSIGNMENT_6.getIndex(), ASSIGNMENT_7.getIndex())),
    PHP_PART_ASSIGNMENTS    (COURSE_5.getIndex(), singletonList(ASSIGNMENT_7.getIndex()));

    private final int courseIndex;
    private final List<Integer> assignmentIndexes;

    public int getCourseIndex() {
        return courseIndex;
    }

    public List<Integer> getAssignmentIndexes() {
        return assignmentIndexes;
    }

    CourseAssignmentIndex(int courseIndex, List<Integer> assignmentIndexes) {
        this.courseIndex = courseIndex;
        this.assignmentIndexes = assignmentIndexes;
    }
}
