package com.example.SpringMongoProject.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.SpringMongoProject.Entity.Student;

public interface StudentRepo extends MongoRepository<Student, String>{

}
