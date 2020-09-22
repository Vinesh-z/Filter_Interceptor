package com.vinesh.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vinesh.example.model.Student;


@Repository
public interface StudentRepository extends MongoRepository<Student, String>{

}
