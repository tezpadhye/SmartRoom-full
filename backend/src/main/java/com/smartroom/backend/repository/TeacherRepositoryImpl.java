package com.smartroom.backend.repository;

import com.smartroom.backend.model.TeacherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


public class TeacherRepositoryImpl implements TeacherRepository {

    private final MongoOperations mongoOperations;

    @Autowired
    public TeacherRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public TeacherModel createTeacher(TeacherModel teacherModel) {
        try {
            return mongoOperations.insert(teacherModel);
        } catch (DuplicateKeyException e) {
            throw new DuplicateKeyException("Teacher with id :- " + teacherModel.getTeacherId() + " already exists");
        } catch (RuntimeException e) {
            throw new RuntimeException("Can't process the request");
        }
    }

    @Override
    public TeacherModel getTeacherById(String teacherId) {
        try {
            Query findQuery = new Query();
            findQuery.addCriteria(new Criteria("teacherName").is(teacherId));
            return mongoOperations.find(findQuery, TeacherModel.class).get(0);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }


}
