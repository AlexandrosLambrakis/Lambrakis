package models.subs;

import interfaces.ViewSubscribable;
import models.Student;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import interfaces.SubscribableStudent;

public class SubStudent implements SubscribableStudent, ViewSubscribable {
    private final List<Student> students = new ArrayList<>();

    private SubStudent(Student ...studentArray) {
        students.addAll(Arrays.asList(studentArray));
    }
    private SubStudent(List<Student> studentList) {students.addAll(studentList);}

    @Override
    public void subscribeStudent(Student student) {
        students.add(student);
    }

    @Override
    public void subscribeStudents(Student... studentArray) {
        students.addAll(Arrays.asList(studentArray));
    }

    @Override
    public void viewSubscribable() {
        students.forEach(student -> System.out.println("\t"+student.customView("\t\t")));
    }

    public static SubStudent build(Student ...studentArray) {
        return new SubStudent(studentArray);
    }

    public static SubStudent build(List<Student> studentList) {
        return new SubStudent(studentList);
    }

    @Override
    public String toString() {
        return "SubCourseStudent{" +
                "students=" + students +
                '}';
    }
}
