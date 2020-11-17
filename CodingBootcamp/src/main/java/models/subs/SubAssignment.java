package models.subs;

import interfaces.SubscribableAssignment;
import interfaces.ViewSubscribable;
import models.assignments.Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SubAssignment implements SubscribableAssignment, ViewSubscribable {
    private final List<Assignment> assignments = new ArrayList<>();

    public SubAssignment(Assignment ...assignmentArray) {
        this.assignments.addAll(Arrays.asList(assignmentArray));
    }
    public SubAssignment(List<Assignment> assignmentList) {
        this.assignments.addAll(assignmentList);
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    @Override
    public void subscribeAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    @Override
    public void subscribeAssignments(Assignment... assignmentArray) {
        assignments.addAll(Arrays.asList(assignmentArray));
    }

    @Override
    public void viewSubscribable() {
        assignments.forEach(assignment -> System.out.println("\t"+assignment.customView("\t\t")));
    }

    public static SubAssignment build(Assignment ...assignmentArray) {
        return new SubAssignment(assignmentArray);
    }

    public static SubAssignment build(List<Assignment> assignmentList) {
        return new SubAssignment(assignmentList);
    }
}
