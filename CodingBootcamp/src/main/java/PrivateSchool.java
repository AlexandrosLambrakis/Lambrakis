import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import models.assignments.*;

import java.time.LocalDate;
import java.util.stream.Collectors;

import models.Student;
import models.Trainer;
import models.courses.Course;
import models.courses.FullTimeCourse;
import models.courses.PartTimeCourse;
import models.identity.CourseIdentity;
import models.identity.StudentIdentity;
import models.subs.SubCourse;
import models.view.StudentAssignmentsOnDate;
import util.PrivateSchoolFactory;
import util.CourseIdentitiesFactory;
import util.StudentIdentitiesFactory;
import util.TimeUtil;

import static models.courses.CourseTimeType.FULLTIME;
import static models.courses.CourseTimeType.PARTTIME;
import static util.MenuUtil.*;

public class PrivateSchool {
    private final List<Student> allStudents = new ArrayList<>();
    private final List<Trainer> allTrainers = new ArrayList<>();
    private final List<Assignment> allAssignments = new ArrayList<>();
    private final List<Course> allCourses = new ArrayList<>();
    private final List<CourseIdentity> courseIdentities = new ArrayList<>();
    private final List<StudentIdentity> studentIdentities = new ArrayList<>();

    private void initWithData() {
        System.out.println("*****Generate synthetic data*****");
        PrivateSchoolFactory.initStudents(allStudents);
        PrivateSchoolFactory.initCourses(allCourses);
        PrivateSchoolFactory.initAssignments(allAssignments);
        PrivateSchoolFactory.initTrainers(allTrainers);
        CourseIdentitiesFactory.initCourseIdentities(courseIdentities, allCourses, allStudents, allAssignments, allTrainers);
        StudentIdentitiesFactory.initStudentIdentities(studentIdentities, allStudents, allCourses, allAssignments);
        System.out.println("*****Synthetic data generated*****");
    }

    private void manualInsertData(Scanner sc) {
        while (true) {
            System.out.println("================================");
            System.out.println("<----Creating course menu---->");
            System.out.println("Give course's title:");
            String courseTitle = sc.next();
            System.out.println("Give course's stream:");
            String courseStream = sc.next();
            courseTypeInfo();
            int typeOption = getValidTimeTypeOption(sc);
            System.out.println("Give course's starting date:");
            LocalDate courseStartingDate = getValidLocalDate(sc);
            System.out.println("Give course's ending date:");
            LocalDate courseEndingDate = getValidLocalDate(sc);
            courseEndingDate = checkStartingEndingDateDiff(sc, courseStartingDate, courseEndingDate);
            Course course;
            if (typeOption == 0) {
                course = FullTimeCourse.build(
                        courseTitle,
                        courseStream,
                        FULLTIME,
                        courseStartingDate,
                        courseEndingDate);
            } else {
                course = PartTimeCourse.build(
                        courseTitle,
                        courseStream,
                        PARTTIME,
                        courseStartingDate,
                        courseEndingDate);
            }
            allCourses.add(course);
            courseIdentities.add(CourseIdentity.build(course));

            System.out.println("*****Course created!*****");
            System.out.println("Do you want to create another course? y/n");
            String yesNo = sc.next();
            if (!yesNo.trim().toLowerCase().startsWith("y")) break;
        }
    }

    private void manualInsertAssignment(Scanner sc) {
        while (true) {
            System.out.println("================================");
            System.out.println("<----Creating Assignment menu---->");
            System.out.println("Give assignment's title:");
            String assignmentTitle = sc.next();
            System.out.println("Give assignment's description");
            String assignmentDescription = sc.next();
            System.out.println("Give assignment's sub date:");
            LocalDate assignmentSubDate = getValidLocalDate(sc);
            System.out.println("Give assignment's oral mark:(integer)");
            int assignmentOralMark = getValidInteger(sc);
            System.out.println("Give assignment's total mark:(integer)");
            int assignmentTotalMark = getValidInteger(sc);

            Assignment assignment;
            assignmentTypeInfo();
            int assignmentType = getValidAssignmentTypeOption(sc);
            if (assignmentType == 0) {
                assignment = GroupProject.build(
                        assignmentTitle,
                        assignmentDescription,
                        assignmentSubDate,
                        assignmentOralMark,
                        assignmentTotalMark);
            } else {
                assignment = IndividualProject.build(
                        assignmentTitle,
                        assignmentDescription,
                        assignmentSubDate,
                        assignmentOralMark,
                        assignmentTotalMark);
            }
            allAssignments.add(assignment);
            courseSearchInfo();
            sc.nextLine();
            String courseTitles = sc.nextLine();

            Arrays.stream(courseTitles.split(","))
                    .map(String::trim)
                    .peek(System.out::println)
                    .forEach(title -> courseIdentities
                            .stream()
                            .filter(courseIdentity -> courseIdentity.getCourse().getTitle().equals(title))
                            .findFirst()
                            .ifPresent(courseIdentity ->
                                    courseIdentity
                                            .getSubCourseAssignment()
                                            .subscribeAssignment(assignment))
                    );
            System.out.println("*****Assignemnt created!*****");
            System.out.println("Do you want to create another assignment? y/n");
            String yesNo = sc.next();
            if (!yesNo.trim().toLowerCase().startsWith("y")) break;
        }
    }

    private void manualInsertStudent(Scanner sc) {
        while (true) {
            System.out.println("================================");
            System.out.println("<----Creating students menu---->");

            System.out.println("Give student's first name:");
            String studentName = sc.next();
            System.out.println("Give student's last name:");
            String studentSurname = sc.next();
            System.out.println("Give student's birth day:");
            LocalDate studentBirthday = getValidLocalDate(sc);
            System.out.println("Give student's tuition fees:(integer)");
            int tuitionFees = getValidInteger(sc);
            Student student = Student.build(studentName, studentSurname, studentBirthday, tuitionFees);
            allStudents.add(student);
            StudentIdentity studentIdentity = StudentIdentity.build(student);

            courseSearchInfo();
            sc.nextLine();
            String titles = sc.nextLine();
            Arrays.stream(titles.split(","))
                    .map(String::trim)
                    .forEach(title -> courseIdentities
                            .stream()
                            .filter(courseIdentity -> courseIdentity.getCourse().getTitle().equals(title))
                            .findFirst()
                            .ifPresent(courseIdentity -> {
                                        courseIdentity.getSubCourseStudent().subscribeStudent(student);
                                        studentIdentity.getSubCourse().subscribeCourse(courseIdentity.getCourse());
                                    }
                            )
                    );
            assignmentSearchInfo();
            titles = sc.nextLine();
            Arrays.stream(titles.split(","))
                    .map(String::trim)
                    .forEach(title -> allAssignments
                            .stream()
                            .filter(assignment -> assignment.getTitle().equals(title))
                            .findFirst()
                            .ifPresent(assignment ->
                                    studentIdentity.getSubAssignment().subscribeAssignment(assignment)
                            )
                    );
            studentIdentities.add(studentIdentity);
            System.out.println("*****Student created!*****");
            System.out.println("Do you want to create another student? y/n");
            String yesNo = sc.next();
            if (!yesNo.trim().toLowerCase().startsWith("y")) break;
        }
    }

    private void manualInsertTrainer(Scanner sc) {
        while (true) {
            System.out.println("================================");
            System.out.println("<----Creating Trainer menu---->");
            System.out.println("Give trainer's first name:");
            String trainerName = sc.next();
            System.out.println("Give trainer's last name:");
            String trainerSurname = sc.next();
            System.out.println("Give trainer's subject:");
            String trainerSubject = sc.next();
            Trainer trainer = Trainer.build(trainerName, trainerSurname, trainerSubject);
            allTrainers.add(trainer);

            courseSearchInfo();
            sc.nextLine();
            String titles = sc.nextLine();
            Arrays.stream(titles.split(","))
                    .map(String::trim)
                    .forEach(title -> courseIdentities
                            .stream()
                            .filter(courseIdentity -> courseIdentity.getCourse().getTitle().equals(title))
                            .findFirst()
                            .ifPresent(courseIdentity ->
                                    courseIdentity.getSubCourseTrainer().subscribeTrainer(trainer))
                    );

            System.out.println("*****Trainer created!*****");
            System.out.println("Do you want to create another trainer? y/n");
            String yesNo = sc.next();
            if (!yesNo.trim().toLowerCase().startsWith("y")) break;
        }
    }


    private void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to generate synthetic data?y/n");
        String yesNo = sc.next();

        if (yesNo.toLowerCase().trim().startsWith("y")) initWithData();
        else {
            manualInsertData(sc);
            manualInsertAssignment(sc);
            manualInsertStudent(sc);
            manualInsertTrainer(sc);
        }
        optionsMenu(sc);
    }

    private void optionsMenu(Scanner sc) {
        boolean runAgain = true;
        while (runAgain) {
            showMenuInfo();
            switch (getValidMenuOption(sc)) {
                case 0: {
                    runAgain = false;
                    break;
                }
                case 1: {
                    allStudents.forEach(System.out::println);
                    break;
                }
                case 2: {
                    allTrainers.forEach(System.out::println);
                    break;
                }
                case 3: {
                    allAssignments.forEach(System.out::println);
                    break;
                }
                case 4: {
                    allCourses.forEach(System.out::println);
                    break;
                }
                case 5: {
                    courseIdentities.forEach(courseIdentity -> {
                        showSubCourseTitle(courseIdentity);
                        courseIdentity.getSubCourseStudent().viewSubscribable();
                    });
                    break;
                }
                case 6: {
                    courseIdentities.forEach(courseIdentity -> {
                        showSubCourseTitle(courseIdentity);
                        courseIdentity.getSubCourseTrainer().viewSubscribable();
                    });
                    break;
                }
                case 7: {
                    courseIdentities.forEach(courseIdentity -> {
                        showSubCourseTitle(courseIdentity);
                        courseIdentity.getSubCourseAssignment().viewSubscribable();
                    });
                    break;
                }
                case 8: {
                    studentIdentities.forEach(studentIdentity -> {
                        showStudentName(studentIdentity);
                        studentIdentity.viewAssignments();
                    });
                    break;
                }
                case 9: {
                    studentIdentities
                            .stream()
                            .filter(studentIdentity -> studentIdentity.getSubCourse().getCourses().size() > 1)
                            .forEach(studentIdentity -> {
                                showStudentName(studentIdentity);
                                studentIdentity.viewCourses();
                            });
                    break;
                }
                case 10: {
                    System.out.println("Type date to search");
                    LocalDate searchingDate = getValidLocalDate(sc);
                    List<LocalDate> mondayFridayList = TimeUtil.setMondayFridayLocalDate(searchingDate);
                    LocalDate monday = mondayFridayList.get(0);
                    LocalDate friday = mondayFridayList.get(1);
                    List<StudentAssignmentsOnDate> searchedList = studentIdentities
                            .stream()
                            .map(studentIdentity ->
                                    StudentAssignmentsOnDate.build(studentIdentity.getStudent(), studentIdentity
                                            .getSubAssignment()
                                            .getAssignments()
                                            .stream()
                                            .filter(assignment -> monday.compareTo(assignment.getSubDateTime()) <= 0 && friday.compareTo(assignment.getSubDateTime()) >= 0)
                                            .collect(Collectors.toList()))
                            )
                            .filter(studentAssignmentsOnDate -> studentAssignmentsOnDate.getAssignments().size() > 0)
                            .collect(Collectors.toList());
                    if (searchedList.size() == 0) {
                        System.out.println("Didn't find any students assignments in " + searchingDate);
                    } else {
                        searchedList.forEach(System.out::println);
                    }
                    break;
                }
            }
        }
    }

    public static void start() {
        System.out.println("Welcome to Coding Bootcamp Alexandros");
        new PrivateSchool().menu();
    }
}
