package com.smartroom.backend.repository;

import com.smartroom.backend.entity.StudentDetails;

public interface StudentRepository {

    StudentDetails getStudentById(String studentId);
}
