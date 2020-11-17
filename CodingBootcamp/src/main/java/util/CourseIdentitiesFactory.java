package util;

import models.Student;
import models.Trainer;
import models.assignments.Assignment;
import models.courses.Course;
import models.data.Courses;
import models.data.indexes.CourseAssignmentIndex;
import models.data.indexes.CourseStudentIndex;
import models.data.indexes.CourseTrainerIndex;
import models.identity.CourseIdentity;
import models.subs.SubAssignment;
import models.subs.SubStudent;
import models.subs.SubTrainer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CourseIdentitiesFactory {
    private CourseIdentitiesFactory() {}

    public static void initCourseIdentities(List<CourseIdentity> courseIdentities, List<Course> allCourses, List<Student> allStudents, List<Assignment> allAssignments, List<Trainer> allTrainers) {
        Arrays.stream(Courses.values()).forEach(course ->
            courseIdentities.add(CourseIdentity.build(
                    allCourses.get(course.getIndex()),
                    SubAssignment.build(getAllCourseAssignments(course.getIndex(), allAssignments)),
                    SubStudent.build(getAllCourseStudents(course.getIndex(), allStudents)),
                    SubTrainer.build(getAllCourseTrainers(course.getIndex(), allTrainers))
        )));
    }

    private static List<Assignment> getAllCourseAssignments(int courseIndex, List<Assignment> allAssignments) {
       return Arrays.stream(CourseAssignmentIndex.values())
                .filter(courseAssignmentIndex -> courseAssignmentIndex.getCourseIndex() == courseIndex)
                .map(CourseAssignmentIndex::getAssignmentIndexes)
                .flatMap(List::stream)
                .map(allAssignments::get)
                .collect(Collectors.toList());
    }

    private static List<Student> getAllCourseStudents(int courseIndex, List<Student> allStudents) {
        return Arrays.stream(CourseStudentIndex.values())
                .filter(courseStudentIndex -> courseStudentIndex.getCourseIndex() == courseIndex)
                .map(CourseStudentIndex::getStudentIndexes)
                .flatMap(List::stream)
                .map(allStudents::get)
                .collect(Collectors.toList());
    }

    private static List<Trainer> getAllCourseTrainers(int courseIndex, List<Trainer> allTrainers) {
        return Arrays.stream(CourseTrainerIndex.values())
                .filter(courseTrainerIndex -> courseTrainerIndex.getCourseIndex() == courseIndex)
                .map(CourseTrainerIndex::getTrainerIndexes)
                .flatMap(List::stream)
                .map(allTrainers::get)
                .collect(Collectors.toList());
    }
}
