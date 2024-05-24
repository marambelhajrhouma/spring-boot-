// DepartmentService.java
package com.example.SpringMongoProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringMongoProject.Entity.Department;
import com.example.SpringMongoProject.Repo.DepartmentRepo;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public void saveOrUpdate(Department department) {
        departmentRepo.save(department);
    }

    public Iterable<Department> listAll() {
        return departmentRepo.findAll();
    }

    public void deleteDepartment(String id) {
        departmentRepo.deleteById(id);
    }

    public Department getDepartmentById(String id) {
        return departmentRepo.findById(id).orElse(null);
    }
    
    public long countDepartments() {
        return departmentRepo.count();
    }
}
