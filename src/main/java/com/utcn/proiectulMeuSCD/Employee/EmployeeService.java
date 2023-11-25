package com.utcn.proiectulMeuSCD.Employee;

import com.utcn.proiectulMeuSCD.DTO.EmployeeBasic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeBasic> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeBasic::new).collect(Collectors.toList());
    }

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void getEmployeeById(Long id) {
        employeeRepository.findById(id);
    }

    public void updateEmployee(Long id, Employee employee) {
        Employee updateTheEmployee = employeeRepository.findEmployeeById(id);
        updateTheEmployee.setManagerId(employee.getManagerId());
        updateTheEmployee.setDepartmentId(employee.getDepartmentId());
        updateTheEmployee.setEmail(employee.getEmail());
        updateTheEmployee.setName(employee.getName());
        employeeRepository.saveAndFlush(updateTheEmployee);
    }

    public void deleteEmployee(Long id) {
        Employee deleteTheEmployee = employeeRepository.findEmployeeById(id);
        employeeRepository.delete(deleteTheEmployee);
    }
}
