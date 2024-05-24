package com.example.SpringMongoProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringMongoProject.Entity.Teacher;
import com.example.SpringMongoProject.Repo.TeacherRepo;

@Service
public class TeacherService {

  @Autowired
  private TeacherRepo repo;

  public void saveorUpdate(Teacher teacher) {
    repo.save(teacher);
  }

  public Iterable<Teacher> listAll() {
    return this.repo.findAll();
  }

  public void deleteTeacher(String id) {
    repo.deleteById(id);
  }

  public Teacher getTeacherByID(String teacherId) {
    return repo.findById(teacherId).get();
  }
}
