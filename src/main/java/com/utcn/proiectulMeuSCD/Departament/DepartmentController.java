package com.utcn.proiectulMeuSCD.Departament;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping(value = "/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(value="/department")
    public List<Department> allDepartments() {
        return departmentService.getAllDepartments();
    }
}
