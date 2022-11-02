package com.smartroom.backend.repository;

import com.smartroom.backend.model.TeacherModel;

import java.util.List;

public interface TeacherRepository {

    TeacherModel createTeacher(TeacherModel teacherModel);

    TeacherModel getTeacherById(String teacherId);

    List<TeacherModel> getAllTeachers();
}
