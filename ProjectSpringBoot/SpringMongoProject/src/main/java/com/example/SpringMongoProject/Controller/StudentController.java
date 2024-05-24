// StudentController.java
package com.example.SpringMongoProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.SpringMongoProject.Entity.Student;
import com.example.SpringMongoProject.Service.StudentServices; // Correction du nom du service

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentServices studentServices; // Correction du nom du service

    @PostMapping(value = "/save")
    private String saveStudent(@RequestBody Student student) {
        studentServices.saveOrUpdate(student); 
        return student.getId();
    }

    @GetMapping(value = "/getAll")
    private Iterable<Student> getStudents() {
        return studentServices.listAll(); // Correction du nom du service
    }

    @PutMapping(value = "/edit/{id}")
    private Student update(@RequestBody Student student, @PathVariable(name = "id") String id) {
        student.setId(id);
        studentServices.saveOrUpdate(student); // Correction du nom du service
        return student;
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable(name = "id") String id) {
        studentServices.deleteStudent(id); // Correction du nom du service
    }

    @GetMapping("/search/{id}")
    private Student getStudent(@PathVariable(name = "id") String id) {
        return studentServices.getStudentById(id); // Correction du nom du service
    }
    
    @GetMapping("/count")
    private long countStudents() {
        return studentServices.countStudents();
    }
    
}
