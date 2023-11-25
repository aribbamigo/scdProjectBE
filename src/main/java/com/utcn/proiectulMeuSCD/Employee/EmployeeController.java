package com.utcn.proiectulMeuSCD.Employee;

import com.utcn.proiectulMeuSCD.DTO.EmployeeBasic;
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
    public List<EmployeeBasic> allEmployees() {
        return employeeService.getAllEmployees();
    }
}
