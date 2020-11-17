package interfaces;

import models.assignments.Assignment;

public interface SubscribableAssignment {
    void subscribeAssignment(Assignment assignment);
    void subscribeAssignments(Assignment ...assignmentArray);
}
