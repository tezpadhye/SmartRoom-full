package com.smartroom.backend.controller;

import com.smartroom.backend.entity.Student;

import com.smartroom.backend.entity.StudentDetails;

import com.smartroom.backend.entity.Teacher;

import com.smartroom.backend.model.StudentModel;
import com.smartroom.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<StudentModel> createStudent(@RequestBody @Valid Student student) throws Exception {
        StudentModel  createdStudent =  teacherService.createStudent(student);
        return new ResponseEntity<>(createdStudent,HttpStatus.CREATED);
    }

    @PutMapping("/update/student")
    public ResponseEntity<Student> predictStudentData(@RequestParam("studentId") String studentId , @RequestBody StudentDetails studentDetails) throws Exception {
        Student updatedStudent = teacherService.updateStudent(studentId,studentDetails);
        return new ResponseEntity<>(updatedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/student/fetch/all")
    public ResponseEntity<List<Student>> fetchAllStudent() throws Exception {
        List<Student> fetchedStudents = teacherService.fetchAllStudent();
        return new ResponseEntity<>(fetchedStudents, HttpStatus.OK);
    }

    @GetMapping("/predict")
    public ResponseEntity<Integer> predictStudentResult(@RequestParam("studentId") String studentId , @RequestParam("subject") Student subject) throws Exception {
        Integer predictedResult = teacherService.predictResult(studentId , subject);
        return new ResponseEntity<>(predictedResult,HttpStatus.OK);

    public ResponseEntity<StudentModel>createStudent(@RequestBody @Valid Student student) throws Exception {
        System.out.println("Debug request call :- " + student);
       return new ResponseEntity<>(teacherService.createStudent(student), HttpStatus.OK);
      //return teacherService.createStudent(student);

    }


}
