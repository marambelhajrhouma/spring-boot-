// DepartmentRepo.java
package com.example.SpringMongoProject.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.SpringMongoProject.Entity.Department;

public interface DepartmentRepo extends MongoRepository<Department, String> {

}
