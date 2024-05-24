package com.example.SpringMongoProject.Controller; // Updated package name

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringMongoProject.Entity.Teacher;
import com.example.SpringMongoProject.Service.TeacherService; 

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/teacher")
public class TeacherController {

  @Autowired
  private TeacherService teacherServices; // Updated Service class name

  @PostMapping(value = "/save")
  private String saveTeacher(@RequestBody Teacher teacher) {
    teacherServices.saveorUpdate(teacher);
    return teacher.get_id();
  }

  @GetMapping(value = "/getAll")
  private Iterable<Teacher> getTeachers() {
    return teacherServices.listAll();
  }

  @PutMapping(value = "/edit/{id}")
  private Teacher update(@RequestBody Teacher teacher, @PathVariable(name = "id") String _id) {
    teacher.set_id(_id);
    teacherServices.saveorUpdate(teacher);
    return teacher;
  }

  @DeleteMapping("/delete/{id}")
  private void delete(@PathVariable(name = "id") String _id) {
    teacherServices.deleteTeacher(_id);
  }

  @RequestMapping("/search/{id}")
  private Teacher getTeacher(@PathVariable(name = "id") String teacherId) {
    return teacherServices.getTeacherByID(teacherId);
  }
}
