package com.smartroom.backend.controller;

import com.smartroom.backend.entity.Student;
import com.smartroom.backend.model.StudentModel;
import com.smartroom.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/teacher")
@PreAuthorize("hasRole('TEACHER')")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }


    @PostMapping("/create/student")
    public StudentModel createStudent(@RequestBody @Valid Student student) throws Exception {
        return teacherService.createStudent(student);
    }


}
