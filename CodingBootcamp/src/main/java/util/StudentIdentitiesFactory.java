package util;

import models.Student;
import models.assignments.Assignment;
import models.courses.Course;
import models.data.Students;
import models.data.indexes.CourseAssignmentIndex;
import models.data.indexes.CourseStudentIndex;
import models.identity.StudentIdentity;
import models.subs.SubAssignment;
import models.subs.SubCourse;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentIdentitiesFactory {
    private StudentIdentitiesFactory() { }

    public static void initStudentIdentities(List<StudentIdentity> studentIdentities, List<Student> allStudents, List<Course> allCourses, List<Assignment> allAssignments) {
        BiPredicate<Students, Student> isStudentDataSameAsStudent = (studentData, student) ->
                studentData.getName().equals(student.getFirstName()) &&
                        studentData.getSurname().equals(student.getLastName()) &&
                        studentData.getTuitionFees() == student.getTuitionFees();

        allStudents.forEach(student ->
                Arrays.stream(Students.values())
                        .filter(studentData -> isStudentDataSameAsStudent.test(studentData, student))
                        .findFirst()
                        .ifPresent(studentData -> {
                            int studentIndex = studentData.getIndex();
                            List<Integer> studentCoursesIndexes = getCoursesOfStudent(studentIndex);
                            List<Integer> studentAssignmentIndexes = getAssignmentsOfStudent(studentCoursesIndexes);

                            studentIdentities.add(StudentIdentity.build(student, getSubCourseOfStudent(studentCoursesIndexes, allCourses), getSubAssignmentOfStudent(studentAssignmentIndexes, allAssignments))
                            );
                        }));
    }

    private static List<Integer> getAssignmentsOfStudent(List<Integer> studentCoursesIndexes) {

        List<Integer> assignmentIndexes = new ArrayList<>();
        CourseAssignmentIndex[] courseAssignmentIndices = CourseAssignmentIndex.values();
        studentCoursesIndexes.stream()
                .map(courseIndex -> courseAssignmentIndices[courseIndex].getAssignmentIndexes())
                .forEach(courseAssignmentIndexes -> {
                    int numOfAssignments;
                    if (courseAssignmentIndexes.size() == 1) numOfAssignments = 1;
                    else numOfAssignments = getRandomNumber(2, 1);
                    IntStream.range(1, numOfAssignments).forEach(i -> addRandomIndexAssignment(assignmentIndexes, courseAssignmentIndexes, 0));
                });
        return assignmentIndexes;
    }

    private static void addRandomIndexAssignment(List<Integer> assignmentIndexes, List<Integer> courseAssignmentIndexes, int searchTries) {
        int randomAssignmentIndex = getRandomNumber(courseAssignmentIndexes.size(), 0);
        if (searchTries == 15) return;
        if (assignmentIndexes.contains(randomAssignmentIndex)) {
            searchTries += 1;
            addRandomIndexAssignment(assignmentIndexes, courseAssignmentIndexes, searchTries);
        } else {
            assignmentIndexes.add(randomAssignmentIndex);
        }
    }

    private static List<Integer> getCoursesOfStudent(int studentIndex) {
        return Arrays.stream(CourseStudentIndex.values())
                .filter(courseStudentIndex -> courseStudentIndex.getStudentIndexes().contains(studentIndex))
                .map(CourseStudentIndex::getCourseIndex)
                .collect(Collectors.toList());
    }

    private static SubCourse getSubCourseOfStudent(List<Integer> studentCoursesIndexes, List<Course> allCourses) {
        return SubCourse.build(studentCoursesIndexes.stream().map(allCourses::get).collect(Collectors.toList()));
    }

    private static SubAssignment getSubAssignmentOfStudent(List<Integer> studentAssignmentIndexes, List<Assignment> allAssignments) {
        return SubAssignment.build(studentAssignmentIndexes.stream().map(allAssignments::get).collect(Collectors.toList()));
    }

    private static int getRandomNumber(int max, int min) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
