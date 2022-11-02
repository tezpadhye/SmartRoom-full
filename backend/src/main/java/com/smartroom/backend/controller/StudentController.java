package com.smartroom.backend.controller;

import com.smartroom.backend.entity.Student;
import com.smartroom.backend.service.StudentAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/student/auth")
public class StudentController {

    private final StudentAuthService service;

    @Autowired
    private StudentController(StudentAuthService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody @Valid Student student) throws Exception {
        service.createStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);


    }

}
