package com.smartroom.backend.service;

import com.smartroom.backend.entity.Student;
import com.smartroom.backend.model.StudentModel;

public interface TeacherService {

    StudentModel createStudent(Student student) throws Exception;
}
