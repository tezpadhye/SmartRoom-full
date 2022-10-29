package com.smartroom.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Document(value = "teacher")
public class TeacherModel {

    @Id
    private String teacherId;

    @NotNull
    @NotEmpty
    private String teacherName;

    @NotNull
    @NotEmpty
    private String classTeacher;

    @NotNull
    @NotEmpty
    private List<String> classes;

    @NotNull
    @NotEmpty
    private String password;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TeacherModel{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", isClassTeacher='" + classTeacher + '\'' +
                ", classes=" + classes +
                ", password='" + password + '\'' +
                '}';
    }
}
