package util;

import models.Student;
import models.Trainer;
import models.assignments.Assignment;
import models.assignments.GroupProject;
import models.assignments.IndividualProject;
import models.courses.Course;
import models.courses.FullTimeCourse;
import models.courses.PartTimeCourse;
import models.data.Assignments;
import models.data.Courses;
import models.data.Students;
import models.data.Trainers;

import java.util.Arrays;
import java.util.List;

import static models.assignments.AssignmentType.GROUP;
import static models.assignments.AssignmentType.INDIVIDUAL;
import static models.courses.CourseTimeType.FULLTIME;
import static models.courses.CourseTimeType.PARTTIME;

public class PrivateSchoolFactory {
    private PrivateSchoolFactory() {}

    public static void initStudents(List<Student> allStudents) {
        Arrays.asList(Students.values()).forEach(student ->
                allStudents.add(Student.build(
                        student.getName(),
                        student.getSurname(),
                        student.getDateBorn(),
                        student.getTuitionFees()))
        );
    }

    public static void initCourses(List<Course> allCourses) {
        Arrays.asList(Courses.values()).forEach(course -> {
                    if(course.getCourseTimeType() == FULLTIME) {
                        allCourses.add(FullTimeCourse.build(
                                course.getTitle(),
                                course.getStream(),
                                course.getCourseTimeType(),
                                course.getStarting_date(),
                                course.getEnding_date()));
                    } else if(course.getCourseTimeType() == PARTTIME) {
                        allCourses.add(PartTimeCourse.build(
                                course.getTitle(),
                                course.getStream(),
                                course.getCourseTimeType(),
                                course.getStarting_date(),
                                course.getEnding_date()));
                    }
        });
    }

    public static void initAssignments(List<Assignment> allAssignments) {
        Arrays.asList(Assignments.values()).forEach(assignment -> {
            if (assignment.getAssignmentType() == GROUP) {
                allAssignments.add(GroupProject.build(
                        assignment.getTitle(),
                        assignment.getDescription(),
                        assignment.getSubDateTime(),
                        assignment.getOralMark(),
                        assignment.getTotalMark()));
            }
            else if(assignment.getAssignmentType() == INDIVIDUAL) {
                allAssignments.add(IndividualProject.build(
                        assignment.getTitle(),
                        assignment.getDescription(),
                        assignment.getSubDateTime(),
                        assignment.getOralMark(),
                        assignment.getTotalMark()));
            }
        });
    }

    public static void initTrainers(List<Trainer> allTrainers) {
        Arrays.asList(Trainers.values()).forEach(trainer ->
                allTrainers.add(Trainer.build(trainer.getFirstName(), trainer.getLastName(), trainer.getSubject())));
    }
}
