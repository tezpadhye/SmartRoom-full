package com.smartroom.backend.repository;

import com.smartroom.backend.entity.Student;
import com.smartroom.backend.entity.StudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

    private final MongoOperations mongoOperations;

    @Autowired
    StudentRepositoryImpl(MongoOperations mongoOperations){
        this.mongoOperations = mongoOperations;
    }

    @Override
    public StudentDetails getStudentById(String studentId) {
        try {
            Query findQuery = new Query();
            findQuery.addCriteria(new Criteria("studentId").is(studentId));
            return mongoOperations.find(findQuery, Student.class, "student").get(0).getStudentDetails();
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("Student with id:- " + studentId + " not found");
        }
    }
}
