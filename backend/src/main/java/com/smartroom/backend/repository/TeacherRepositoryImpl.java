package com.smartroom.backend.repository;

import com.smartroom.backend.entity.Student;
import com.smartroom.backend.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {

    private final MongoOperations mongoOperations;

    @Autowired
    TeacherRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public StudentModel createStudent(Student student) throws Exception {
        try {
            mongoOperations.insert(student, "student");
            StudentModel studentModel = new StudentModel(student.getStudentId() , student.getPassword());
            return studentModel;
        } catch (DuplicateKeyException e) {
            throw new DuplicateKeyException("Student with this id is already created");
        }
    }
}
