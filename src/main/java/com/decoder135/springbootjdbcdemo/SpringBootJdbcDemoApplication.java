package com.decoder135.springbootjdbcdemo;

import com.decoder135.springbootjdbcdemo.dao.DAO;
import com.decoder135.springbootjdbcdemo.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringBootJdbcDemoApplication {

    private static DAO<Course> dao;

    public SpringBootJdbcDemoApplication(DAO<Course> dao) {
        this.dao = dao;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcDemoApplication.class, args);

        System.out.println("\n Create Courses -------------------- \n");
        Course newCourse = new Course("Spring Boot + Vue", "New Course", "https://www.decoder135.com/courses");
        dao.create(newCourse);


        System.out.println("\n All Courses -------------------- \n");
        List<Course> courses = dao.list();

        courses.forEach(System.out::println);
    }

}
