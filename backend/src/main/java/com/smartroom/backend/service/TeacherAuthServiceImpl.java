package com.smartroom.backend.service;

import com.smartroom.backend.entity.Teacher;
import com.smartroom.backend.model.TeacherModel;
import com.smartroom.backend.repository.TeacherAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TeacherAuthServiceImpl implements TeacherAuthService {

    private final TeacherAuthRepo repo;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public TeacherAuthServiceImpl(TeacherAuthRepo repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public TeacherModel createTeacher(Teacher teacher) throws Exception {
        try {
            TeacherModel model = convertToModel(teacher);
            repo.createTeacher(model);
            return model;
        } catch (Exception e) {
            throw new Exception(e);
        }
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
