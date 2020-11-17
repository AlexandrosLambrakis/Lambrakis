package interfaces;

import models.Student;

public interface SubscribableStudent {
    void subscribeStudent(Student student);
    void subscribeStudents(Student ...studentArray);
}
