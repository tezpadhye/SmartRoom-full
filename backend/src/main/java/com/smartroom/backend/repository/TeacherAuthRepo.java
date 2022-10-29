package com.smartroom.backend.repository;

import com.smartroom.backend.model.TeacherModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherAuthRepo extends MongoRepository<TeacherModel, String>, TeacherRepository {


}
