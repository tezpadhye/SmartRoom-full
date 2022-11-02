package com.smartroom.backend.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Document(collection = "student")
public class Student {

    @NotNull
    @NotEmpty
    private String studentId;


    private final String password = UUID.randomUUID().toString();

    @NotNull
    private StudentParameter studentParameter;


    public Student() {
    }

    public Student(String studentId, StudentParameter studentParameter) {
        this.studentId = studentId;
        this.studentParameter = studentParameter;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }


    public StudentParameter getStudentParameter() {
        return studentParameter;
    }

    public void setStudentParameter(StudentParameter studentParameter) {
        this.studentParameter = studentParameter;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", password='" + password + '\'' +
                ", studentParameter=" + studentParameter +
                '}';
    }
}
