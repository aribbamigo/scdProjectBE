package com.utcn.proiectulMeuSCD.DTO;


import com.utcn.proiectulMeuSCD.Departament.Department;
import com.utcn.proiectulMeuSCD.Employee.Employee;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
        this.departmentId = employee.getDepartment() != null ? employee.getDepartment().getId() : null;
        this.managerId = employee.getManager() != null ? employee.getManager().getId() : this.id;
    }
}
