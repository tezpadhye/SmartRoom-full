package com.smartroom.backend.service;

import com.smartroom.backend.entity.Teacher;
import com.smartroom.backend.exception.InvalidMatchingPasswordException;
import com.smartroom.backend.model.TeacherModel;
import com.smartroom.backend.repository.StudentAuthRepo;
import com.smartroom.backend.repository.TeacherAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherAuthServiceImpl implements TeacherAuthService {

    private final TeacherAuthRepo teacherAuthRepo;

    private final StudentAuthRepo studentAuthRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public TeacherAuthServiceImpl(TeacherAuthRepo teacherAuthRepo, StudentAuthRepo studentAuthRepo, PasswordEncoder passwordEncoder) {
        this.teacherAuthRepo = teacherAuthRepo;
        this.studentAuthRepo = studentAuthRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public TeacherModel createTeacher(Teacher teacher) throws Exception {
        try {
            if (checkMatchingPassword(teacher)) {
                TeacherModel model = convertToModel(teacher);
                teacherAuthRepo.createTeacher(model);
                return model;
            } else {
                throw new InvalidMatchingPasswordException("password doesn't matches with matching password");
            }
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
    }


    @Override
    public List<TeacherModel> fetchAllTeacher() throws Exception {
        try {
            List<TeacherModel> fetchedTeachers = teacherAuthRepo.getAllTeachers();
            return fetchedTeachers;
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
    }

    private boolean checkMatchingPassword(Teacher teacher) {

        String password = teacher.getPassword();
        String matchingPassword = teacher.getMatchingPassword();

        return password.equals(matchingPassword);

    }

    private TeacherModel convertToModel(Teacher teacher) {
        TeacherModel teacherModel = new TeacherModel();
        teacherModel.setTeacherId(teacher.getTeacherId());
        teacherModel.setTeacherName(teacher.getTeacherName());
        teacherModel.setClassTeacher(teacher.getClassTeacher());
        teacherModel.setClasses(teacher.getClasses());
        teacherModel.setPassword(passwordEncoder.encode(teacher.getPassword()));
        return teacherModel;
    }
}
