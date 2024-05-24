// DepartmentController.java
package com.example.SpringMongoProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.SpringMongoProject.Entity.Department;
import com.example.SpringMongoProject.Service.DepartmentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "/save")
    private String saveDepartment(@RequestBody Department department) {
        departmentService.saveOrUpdate(department);
        return department.getId();
    }

    @GetMapping(value = "/getAll")
    private Iterable<Department> getDepartments() {
        return departmentService.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Department update(@RequestBody Department department, @PathVariable(name = "id") String id) {
        department.setId(id);
        departmentService.saveOrUpdate(department);
        return department;
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable(name = "id") String id) {
        departmentService.deleteDepartment(id);
    }

    @GetMapping("/search/{id}")
    private Department getDepartment(@PathVariable(name = "id") String id) {
        return departmentService.getDepartmentById(id);
    }
    
    @GetMapping("/count")
    private long countDepartments() {
        return departmentService.countDepartments();
    }
}
