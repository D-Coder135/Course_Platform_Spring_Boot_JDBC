package com.decoder135.springbootjdbcdemo.model;

public class Course {

    private int courseId;

    private String title;

    private String description;

    private String link;

    public Course() {
    }

    public Course(String title, String description, String link) {
        this.title = title;
        this.description = description;
        this.link = link;
    }
}
