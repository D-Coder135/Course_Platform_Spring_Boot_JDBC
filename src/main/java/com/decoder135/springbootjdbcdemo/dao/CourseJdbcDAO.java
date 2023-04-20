package com.decoder135.springbootjdbcdemo.dao;

import com.decoder135.springbootjdbcdemo.model.Course;
import org.slf4j.ILoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CourseJdbcDAO implements DAO<Course> {


    private JdbcTemplate jdbcTemplate;

    public CourseJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Course> rowMapper = (rs, rowNum) -> {
      Course course = new Course();
      course.setCourseId(rs.getInt("course_id"));
      course.setTitle(rs.getString("title"));
      course.setDescription(rs.getString("description"));
      course.setLink(rs.getString("link"));
      return course;
    };

    @Override
    public List<Course> list() {
        String query = "SELECT course_id, title, description, link from course";
        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public void create(Course course) {
        String query = "insert into course(title, description, link) values(?, ?, ?)";
        int insertCount = jdbcTemplate.update(query, course.getTitle(), course.getDescription(), course.getLink());

        if (insertCount == 1) {
            System.out.println("New course created: " + course.getTitle());
        }
    }

    @Override
    public Optional<Course> get(int id) {
        String query = "SELECT course_id, title, description, link from course where course_id = ?";
        Course course = null;
        try {
            course = jdbcTemplate.queryForObject(query, new Object[]{id}, rowMapper);
        } catch (DataAccessException exception) {
            System.err.println("Course not found: " + id);
        }
        return Optional.empty();
    }

    @Override
    public void update(Course course, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
