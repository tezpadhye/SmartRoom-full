package com.smartroom.backend.repository;

import com.smartroom.backend.entity.Student;
import com.smartroom.backend.model.StudentModel;

public interface TeacherRepository {

    StudentModel createStudent(Student student) throws Exception;
}
