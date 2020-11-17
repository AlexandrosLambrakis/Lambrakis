package util;

import models.identity.CourseIdentity;
import models.identity.StudentIdentity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuUtil {
    private MenuUtil() {}

    public static void showMenuInfo() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Press 0: To exit the program");
        System.out.println("Press 1: To show all the students");
        System.out.println("Press 2: To show all the trainers");
        System.out.println("Press 3: To show all assignments");
        System.out.println("Press 4: To show all courses");
        System.out.println("Press 5: To show all students per course");
        System.out.println("Press 6: To show all trainers per course");
        System.out.println("Press 7: To show all assignments per course");
        System.out.println("Press 8: To show all assignments per student");
        System.out.println("Press 9: To show a list of students that belong to more than one courses");
        System.out.println("Press 10: Search students' assignments deadline by date within a week");
    }

    public static void courseTypeInfo() {
        System.out.println("Give course's type:\nFor FullTime press 0\nFor PartTime press 1");
    }

    public static void courseSearchInfo() {
        System.out.println("Give course title or titles that student belongs to:");
        System.out.println("If more than 2, separate them with comma");
    }

    public static void assignmentSearchInfo() {
        System.out.println("Give assignment title or titles that student belongs to:");
        System.out.println("If more than 2, separate them with comma");
    }

    public static void assignmentTypeInfo() {
        System.out.println("Build Assigment project\nPress 0 for group project\nPress 1 for individual project");
    }

    public static int getValidMenuOption(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Menu option was wrong. Type number option between 0 and 10...");
            sc.next();
        }
        return sc.nextInt();
    }

    public static int getValidTimeTypeOption(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Course type option was wrong. Type number option between 0 and 1...");
            courseTypeInfo();
            sc.next();
        }
        //
        //if(timeTypeOption > 1 || timeTypeOption < 0)
        return sc.nextInt();
    }

    public static int getValidAssignmentTypeOption(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Course type option was wrong. Type number option between 0 and 1...");
            assignmentTypeInfo();
            sc.next();
        }
        //
        //if(timeTypeOption > 1 || timeTypeOption < 0)
        return sc.nextInt();
    }

    public static int getValidInteger(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Must be type integer, type again");
            sc.next();
        }
        return sc.nextInt();
    }

    public static LocalDate getValidLocalDate(Scanner sc) {
        String datePattern = "dd/MM/yyyy";
        System.out.println("Date must be of pattern: " + datePattern);
        String date = sc.next();
        try {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern(datePattern));
        } catch (Exception e) {
            System.out.println("Wrong date format pattern, try again");
            return getValidLocalDate(sc);
        }
    }

    public static LocalDate checkStartingEndingDateDiff(Scanner sc, LocalDate startingDate, LocalDate endingDate) {

        while (startingDate.compareTo(endingDate) > 0) {
            System.out.println("Ending date can't be before starting date! Try ending date again..");
            endingDate = getValidLocalDate(sc);
        }

        return endingDate;
    }

    public static void showSubCourseTitle(CourseIdentity courseIdentity) {
        System.out.println("Course: "+ courseIdentity.getCourse().getTitle() +"::" + courseIdentity.getCourse().getStream());
    }

    public static void showStudentName(StudentIdentity studentIdentity) {
        System.out.println("Student: "+ studentIdentity.getStudent().getFirstName()+ " " + studentIdentity.getStudent().getLastName());
    }
}
