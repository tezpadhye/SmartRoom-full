package com.smartroom.backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.util.HashMap;
import java.util.Random;

@Document(collection = "student")
public class Student {

    // student  + unique id
    @NotNull
    @NotEmpty
    @Id
    private String studentId;

    @NotNull
    @NotEmpty
    private String studentName;

    @NotNull
    @NotEmpty
    @Email
    private String email;


    private String password = String.valueOf(new Random().nextInt(999999));

    @NotNull
    @NotEmpty
    private String standard;

    @NotNull
    @NotEmpty
    private String batch;

    @NotNull
    @NotEmpty
    private String dob;

    @NotNull
    @NotEmpty
    private String fullAddress;

    @NotNull
    @Min(10)
    @Max(10)
    private Long phone;

    @NotNull
    @NotEmpty
    private String motherName;

    @NotNull
    @NotEmpty
    private String fatherName;

    @NotNull
    @NotEmpty
    private StudentParameter studentParameter;

    @NotNull
    @NotEmpty
    private HashMap<String, Integer> studentMarks;

    private String role = "ROLE_STUDENT";

    public Student() {
    }

    public Student(String studentId, String studentName, String email, String password, String standard, String batch, String dob, String fullAddress, Long phone, String motherName, String fatherName, StudentParameter studentParameter, HashMap<String, Integer> studentMarks, String role) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.password = password;
        this.standard = standard;
        this.batch = batch;
        this.dob = dob;
        this.fullAddress = fullAddress;
        this.phone = phone;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.studentParameter = studentParameter;
        this.studentMarks = studentMarks;
        this.role = role;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public StudentParameter getStudentParameter() {
        return studentParameter;
    }

    public void setStudentParameter(StudentParameter studentParameter) {
        this.studentParameter = studentParameter;
    }

    public HashMap<String, Integer> getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(HashMap<String, Integer> studentMarks) {
        this.studentMarks = studentMarks;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", standard='" + standard + '\'' +
                ", batch='" + batch + '\'' +
                ", dob='" + dob + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                ", phone=" + phone +
                ", motherName='" + motherName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", studentParameter=" + studentParameter +
                ", studentMarks=" + studentMarks +
                ", role='" + role + '\'' +
                '}';
    }
}
