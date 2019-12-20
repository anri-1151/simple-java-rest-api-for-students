package com.ibsu.demo.services;

import com.ibsu.demo.dto.AddEditDepartment;
import com.ibsu.demo.entities.Department;
import com.ibsu.demo.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Department getDeparmentById(Long id) throws Exception {
        return departmentRepository
                .findById(id)
                .orElseThrow(
                    () -> new Exception("NOT_FOUND")
                );
    }

    public List<Department> getByName(String name) {
        return departmentRepository.getByName(name);
    }

    @Transactional
    public Department addDepartment(AddEditDepartment addEditDepartment) {
        Department department = new Department();
        department.setDepartmentName(addEditDepartment.getDepartmentName());
        return departmentRepository.save(department);
    }

    @Transactional
    public Department editDepartment(AddEditDepartment addEditDepartment) throws Exception {
        Department department = departmentRepository
                .findById(addEditDepartment.getDepartmentId())
                .orElseThrow(() -> new Exception("DEPARTMENT_NOT_FOUND"));
        department.setDepartmentName(addEditDepartment.getDepartmentName());
        return departmentRepository.save(department);
    }
}
