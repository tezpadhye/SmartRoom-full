package com.smartroom.backend.service;

import com.smartroom.backend.entity.Student;
import com.smartroom.backend.repository.StudentAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentAuthServiceImpl implements StudentAuthService {

    private final StudentAuthRepo studentAuthRepo;

    @Autowired
    public StudentAuthServiceImpl(StudentAuthRepo studentAuthRepo) {
        this.studentAuthRepo = studentAuthRepo;
    }

    @Override
    public Student createStudent(Student student) throws Exception {
        try {

            return studentAuthRepo.createStudent(student);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }


}

