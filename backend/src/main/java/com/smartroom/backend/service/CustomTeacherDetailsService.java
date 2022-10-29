package com.smartroom.backend.service;

import com.smartroom.backend.model.CustomTeacherDetails;
import com.smartroom.backend.model.TeacherModel;
import com.smartroom.backend.repository.TeacherAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomTeacherDetailsService implements UserDetailsService {

    private final TeacherAuthRepo teacherAuthRepo;

    @Autowired
    public CustomTeacherDetailsService(TeacherAuthRepo teacherAuthRepo) {
        this.teacherAuthRepo = teacherAuthRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String teacherId) throws UsernameNotFoundException {
        TeacherModel teacherModel = teacherAuthRepo.getTeacherById(teacherId);
        if (teacherModel == null) {
            throw new UsernameNotFoundException("No teacher with given name found");
        }

        return new CustomTeacherDetails(teacherModel);
    }
}
