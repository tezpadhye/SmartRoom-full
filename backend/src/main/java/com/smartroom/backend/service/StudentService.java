package com.smartroom.backend.service;

import com.smartroom.backend.entity.StudentDetails;

public interface StudentService {

    StudentDetails getStudentDetails(String studentId);
}
