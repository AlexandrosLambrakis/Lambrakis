package interfaces;

import models.courses.Course;

public interface SubscribableCourse {
    void subscribeCourse(Course course);
    void subscribeCourses(Course ...courseArray);
}
