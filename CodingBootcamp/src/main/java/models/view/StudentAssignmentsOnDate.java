package models.view;

import models.Student;
import models.assignments.Assignment;

import java.util.ArrayList;
import java.util.List;

public class StudentAssignmentsOnDate {
    private final Student student;
    private final List<Assignment> assignments = new ArrayList<>();

    public StudentAssignmentsOnDate(Student student, List<Assignment> assignments) {
        this.student = student;
        this.assignments.addAll(assignments);
    }

    public Student getStudent() {
        return student;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    @Override
    public String toString() {
        return "StudentAssignmentsOnDate:" +
                "\n\t" + student.customView("\t\t") +
                "\n\t" + assignments;
    }

    public static StudentAssignmentsOnDate build(Student student, List<Assignment> assignments) {
        return new StudentAssignmentsOnDate(student, assignments);
    }
}
