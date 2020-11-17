package models.subs;

import interfaces.SubscribableCourse;
import interfaces.ViewSubscribable;
import models.courses.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubCourse implements SubscribableCourse, ViewSubscribable {
    private final List<Course> courses = new ArrayList<>();

    public SubCourse(Course ...courseArray) {
        this.courses.addAll(Arrays.asList(courseArray));
    }
    public SubCourse(List<Course> courseList) {
        this.courses.addAll(courseList);
    }

    @Override
    public void subscribeCourse(Course course) {
        this.courses.add(course);
    }

    @Override
    public void subscribeCourses(Course... courseArray) {
        this.courses.addAll(Arrays.asList(courseArray));
    }

    @Override
    public void viewSubscribable(){
        courses.forEach(course -> System.out.println("\t"+course.customView("\t\t")));
    }

    public List<Course> getCourses() {
        return courses;
    }

    public static SubCourse build(Course ...courseArray){
       return new SubCourse(courseArray);
    }

    public static SubCourse build(List<Course> courseList) {
        return new SubCourse(courseList);
    }
}
