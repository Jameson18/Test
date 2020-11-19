package itmostady.lesson22lambda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class UniTestFilter {
    public static void main(String[] args) {
        University university = new University();
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        System.out.println("Original List");
        System.out.println(university.getCourses());
        List<Course> minDur = university.filtered(course -> course.getDuration() < 3);
        System.out.println("Меньше 3 месяцев" + minDur);
        List<Course> minPrice = university.filtered(course -> course.getPrice() < 20000);
        System.out.println("20000 " + minPrice);
        List<Course> nameJJD = university.filtered(course -> course.getName().startsWith("JJD"));
        System.out.println("name JJD " + nameJJD);
        List<Course> durPrice = university.filtered(course -> course.getDuration() < 3
                & course.getPrice() < 20000);
        System.out.println("Duration & Price " + durPrice);
        List<Course> durPriceJJD = university.filtered(course -> course.getDuration() < 3
                & (course.getPrice() < 20000 | course.getName().startsWith("JJD")));
        System.out.println("durPriceJJD " + durPriceJJD);




    }
}
