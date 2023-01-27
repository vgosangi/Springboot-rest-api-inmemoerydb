package com.AshvFinance.practice.Springbootrestapi.Service;

import com.AshvFinance.practice.Springbootrestapi.Entity.Department;
import com.AshvFinance.practice.Springbootrestapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImplementation{

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);
    }

    public List<Department> getDepartmentList(){
        return departmentRepository.findAll();
    }

    public Department getDepartmentByIdt( Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    public void  deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public Department saveDepartmentByID(Long departmentId,Department department) {
        Department depDb = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDb.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDb.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDb.setDepartmentCode(department.getDepartmentCode());
        }


        return departmentRepository.save(depDb);
    }

    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
