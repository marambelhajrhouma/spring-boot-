// StudentServices.java
package com.example.SpringMongoProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringMongoProject.Entity.Student;
import com.example.SpringMongoProject.Repo.StudentRepo;

@Service
public class StudentServices {

    @Autowired
    private StudentRepo studentRepo;

    public void saveOrUpdate(Student student) {
        studentRepo.save(student);
    }

    public Iterable<Student> listAll() {
        return studentRepo.findAll();
    }

    public void deleteStudent(String id) {
        studentRepo.deleteById(id);
    }

    public Student getStudentById(String id) {
        return studentRepo.findById(id).orElse(null);
    }
    
    public long countStudents() {
        return studentRepo.count();
    }

}
