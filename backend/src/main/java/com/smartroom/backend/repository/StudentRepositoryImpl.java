package com.smartroom.backend.repository;

import com.smartroom.backend.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

public class StudentRepositoryImpl implements StudentRepository {

    private final MongoOperations mongoOperations;

    @Autowired
    public StudentRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public Student createStudent(Student student) {
        return mongoOperations.insert(student);
    }
}
