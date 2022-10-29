package com.smartroom.backend.repository;

import com.smartroom.backend.model.TeacherModel;

public interface TeacherRepository {

    TeacherModel createTeacher(TeacherModel teacherModel);

    TeacherModel getTeacherById(String teacherId);
}
