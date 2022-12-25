package com.smartroom.backend.service;

import com.smartroom.backend.email.EmailSender;
import com.smartroom.backend.entity.Student;
import com.smartroom.backend.model.StudentModel;
import com.smartroom.backend.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final PasswordEncoder passwordEncoder;

    private final EmailSender emailSender;

    @Autowired
    TeacherServiceImpl(TeacherRepository teacherRepository, PasswordEncoder passwordEncoder, EmailSender emailSender) {
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailSender = emailSender;
    }

    @Override
    public StudentModel createStudent(Student student) throws Exception {
        try {
            String password = student.getPassword();
            System.out.println("Student password:- " + password);
            student.setPassword(passwordEncoder.encode(password));
            StudentModel savedStudent = teacherRepository.createStudent(student);
            String emailSubject = "User Id :- " +
                    student.getStudentId() + "\n" + "Password :- " + password;
            emailSender.sendEmail(savedStudent.getEmail(),emailSubject, "SmartRoom Credentials");
            return savedStudent;
        } catch (DuplicateKeyException e) {
            throw new DuplicateKeyException("Student with this id is already created");
        }
        catch (Exception e){

            throw new Exception(e.getLocalizedMessage());
        }
    }
}
