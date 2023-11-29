package com.utcn.proiectulMeuSCD.Departament;

import com.utcn.proiectulMeuSCD.DTO.DepartmentBasic;
import com.utcn.proiectulMeuSCD.DTO.EmployeeBasic;
import com.utcn.proiectulMeuSCD.Employee.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public List<DepartmentBasic> getAllDepartments(){
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(DepartmentBasic::new).collect(Collectors.toList());
    }

    public void createDepartment(DepartmentBasic department) {
        departmentRepository.save(fromBasicToDepartment(department));
    }

    public DepartmentBasic getDepartmentById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        DepartmentBasic departmentBasic = new DepartmentBasic();
        department.ifPresent(value -> departmentBasic.setId(value.getId()));
        department.ifPresent(value -> departmentBasic.setParentId(value.getParent().getId()));
        department.ifPresent(value -> departmentBasic.setDescription(value.getDescription()));
        return departmentBasic;
    }

    public void updateDepartment(Long id, DepartmentBasic department) {
        Department updateTheDepartment = departmentRepository.findDepartmentById(id);
        updateTheDepartment.setDescription(department.getDescription());
        updateTheDepartment.setParent(departmentRepository.findDepartmentById(department.getParentId()));
        departmentRepository.saveAndFlush(updateTheDepartment);
    }

    public void deleteDepartment(Long id) {
        Department deleteTheDepartment = departmentRepository.findDepartmentById(id);
        departmentRepository.delete(deleteTheDepartment);
    }

    private Department fromBasicToDepartment(DepartmentBasic department) {
        Department parent = departmentRepository.findDepartmentById(department.getParentId());
        Department departmentConverted = new Department();
        departmentConverted.setDescription(department.getDescription());
        departmentConverted.setParent(parent);
        return departmentConverted;
    }
}
