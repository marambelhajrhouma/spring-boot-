package com.example.SpringMongoProject.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.SpringMongoProject.Entity.Teacher;

public interface TeacherRepo extends MongoRepository<Teacher, String> {

}
