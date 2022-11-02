package com.smartroom.backend.service;

import com.smartroom.backend.entity.Student;
import com.smartroom.backend.entity.Teacher;
import com.smartroom.backend.model.TeacherModel;

import java.util.List;

public interface TeacherAuthService {

    TeacherModel createTeacher(Teacher teacher) throws Exception;

    List<TeacherModel> fetchAllTeacher() throws Exception;


}
