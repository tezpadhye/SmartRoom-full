package com.smartroom.backend.controller;

import com.smartroom.backend.entity.Student;
import com.smartroom.backend.entity.Teacher;
import com.smartroom.backend.model.StudentModel;
import com.smartroom.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
@PreAuthorize("hasRole('TEACHER')")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }


    @PostMapping("/create/student")
    public ResponseEntity<StudentModel>createStudent(@RequestBody @Valid Student student) throws Exception {
        System.out.println("Debug request call :- " + student);
       return new ResponseEntity<>(teacherService.createStudent(student), HttpStatus.OK);
      //return teacherService.createStudent(student);
    }


}
