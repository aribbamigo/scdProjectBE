package com.utcn.proiectulMeuSCD.Employee;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(value="/getAllEmployees")
    public List<Employee> allEmployees() {
        return employeeService.getAllEmployees();
    }
}
