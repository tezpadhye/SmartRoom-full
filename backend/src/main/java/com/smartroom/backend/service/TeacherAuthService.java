package com.smartroom.backend.service;

import com.smartroom.backend.entity.Teacher;
import com.smartroom.backend.model.TeacherModel;

public interface TeacherAuthService {

    TeacherModel createTeacher(Teacher teacher) throws Exception;
}
