package com.utcn.proiectulMeuSCD.Employee;

import com.utcn.proiectulMeuSCD.DTO.EmployeeBasic;
import com.utcn.proiectulMeuSCD.Departament.Department;
import com.utcn.proiectulMeuSCD.Departament.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<EmployeeBasic> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
            return employees.stream().map(EmployeeBasic::new).collect(Collectors.toList());
    }

    public void createEmployee(EmployeeBasic employee) {
        employeeRepository.save(fromBasicToEmployee(employee));
    }

    private Employee fromBasicToEmployee(EmployeeBasic employee) {
        Employee manager = employeeRepository.findEmployeeById(employee.getManagerId());
        Department department = departmentRepository.findDepartmentById(employee.getDepartmentId());
        Employee employeeConverted = new Employee();
        employeeConverted.setName(employee.getName());
        employeeConverted.setEmail(employee.getEmail());
        employeeConverted.setDepartment(department);
        employeeConverted.setManager(manager);
        return employeeConverted;
    }

    public EmployeeBasic getEmployeeById(Long id) {
        return new EmployeeBasic(employeeRepository.findEmployeeById(id));
    }

    public void updateEmployee(Long id, EmployeeBasic employee) {
        Employee updateTheEmployee = employeeRepository.findEmployeeById(id);
        updateTheEmployee.setManager(employeeRepository.findEmployeeById(employee.getManagerId()));
        updateTheEmployee.setDepartment(departmentRepository.findDepartmentById(employee.getDepartmentId()));
        updateTheEmployee.setEmail(employee.getEmail());
        updateTheEmployee.setName(employee.getName());
        employeeRepository.saveAndFlush(updateTheEmployee);
    }

    public void deleteEmployee(Long id) {
        List<Employee> employees = employeeRepository.getAllByManagerId(id);
        employees.forEach(employee -> employee.setManager(employeeRepository.findEmployeeById(employee.getId())));
        employeeRepository.saveAllAndFlush(employees);
        employeeRepository.deleteById(id);
    }
}
