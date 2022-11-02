package com.smartroom.backend.repository;

import com.smartroom.backend.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentAuthRepo extends MongoRepository<Student,String>,StudentRepository {

}
