package com.decoder135.springbootjdbcdemo;

import com.decoder135.springbootjdbcdemo.dao.DAO;
import com.decoder135.springbootjdbcdemo.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJdbcDemoApplication {

    private DAO<Course> dao;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcDemoApplication.class, args);
    }

}
