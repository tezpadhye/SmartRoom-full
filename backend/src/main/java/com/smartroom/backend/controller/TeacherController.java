package com.smartroom.backend.controller;

import com.smartroom.backend.entity.Teacher;
import com.smartroom.backend.model.TeacherModel;
import com.smartroom.backend.service.TeacherAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/teacher/auth")
public class TeacherController {

    private final TeacherAuthService service;

    @Autowired
    public TeacherController(TeacherAuthService service) {
        this.service = service;
    }


    @PostMapping("/signup")
    public ResponseEntity<TeacherModel> signUpTeacher(@RequestBody @Valid Teacher teacher) throws Exception {
        TeacherModel savedTeacher = service.createTeacher(teacher);
        return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
    }


    @GetMapping("/login/teacher")
    public String loginTeacher() {
        return "login";
    }


}
