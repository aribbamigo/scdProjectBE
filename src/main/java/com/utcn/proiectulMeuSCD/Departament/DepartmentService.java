package com.utcn.proiectulMeuSCD.Departament;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public List<Department> getAllDepartments(){

        return departmentRepository.findAll();
    }

    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void getDepartmentById(Long id) {
        departmentRepository.findById(id);
    }

    public void updateDepartment(Long id, Department department) {
        Department updateTheDepartment = departmentRepository.findById(id);
        updateTheDepartment.setDescription(department.getDescription());
        updateTheDepartment.setParentID(department.getParentID());
        departmentRepository.saveAndFlush(updateTheDepartment);
    }

    public void deleteDepartment(Long id) {
        Department deleteTheDepartment = departmentRepository.findById(id);
        departmentRepository.delete(deleteTheDepartment);
    }

}
