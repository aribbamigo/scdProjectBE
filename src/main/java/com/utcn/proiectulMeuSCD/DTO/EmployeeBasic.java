package com.utcn.proiectulMeuSCD.DTO;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.utcn.proiectulMeuSCD.Departament.Department;
import com.utcn.proiectulMeuSCD.Employee.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class EmployeeBasic {

    private Long id;

    private String name;

    private String email;

    private Long departmentId;

    private Long managerId;

    public EmployeeBasic(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.email = employee.getEmail();
        this.departmentId = employee.getDepartmentId().getId();
        this.managerId = employee.getManagerId() != null ? employee.getManagerId().getId() : this.id;
    }
}
