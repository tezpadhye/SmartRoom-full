package com.smartroom.backend.model;

public class StudentModel {

    private String studentId;

    private String password;

    public StudentModel() {
    }

    public StudentModel(String username, String password) {
        this.studentId = username;
        this.password = password;
    }

    public String getUsername() {
        return studentId;
    }

    public void setUsername(String username) {
        this.studentId = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
