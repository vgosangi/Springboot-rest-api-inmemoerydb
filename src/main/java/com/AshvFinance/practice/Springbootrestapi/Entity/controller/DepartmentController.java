package com.AshvFinance.practice.Springbootrestapi.Entity.controller;

import com.AshvFinance.practice.Springbootrestapi.Entity.Department;

import com.AshvFinance.practice.Springbootrestapi.Service.DepartmentServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentServiceImplementation departmentService;



    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){

        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartmentList(){
        return departmentService.getDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentByIdt(@PathVariable("id") Long departmentId){
        return departmentService.getDepartmentByIdt(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
         departmentService.deleteDepartmentById(departmentId);
         return "Department deleted Successfully";

    }

    @PutMapping("/departments/{id}")
    public Department saveDepartmentByID(@PathVariable("id") Long departmentId, @RequestBody Department department){

        return departmentService.saveDepartmentByID(departmentId,department);
    }



    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }


}
