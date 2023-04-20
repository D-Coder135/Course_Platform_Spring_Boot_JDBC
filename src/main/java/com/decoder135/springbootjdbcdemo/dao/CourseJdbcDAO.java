package com.decoder135.springbootjdbcdemo.dao;

import com.decoder135.springbootjdbcdemo.model.Course;

import java.util.List;
import java.util.Optional;

public class CourseJdbcDAO implements DAO<Course> {

    @Override
    public List<Course> list() {
        return null;
    }

    @Override
    public void create(Course course) {

    }

    @Override
    public Optional<Course> get(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Course course, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
