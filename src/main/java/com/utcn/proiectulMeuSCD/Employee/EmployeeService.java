package com.utcn.proiectulMeuSCD.Employee;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){

        return employeeRepository.findAllEmployees();
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
