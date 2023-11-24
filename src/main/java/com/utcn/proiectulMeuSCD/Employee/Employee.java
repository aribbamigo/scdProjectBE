package com.utcn.proiectulMeuSCD.Employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.utcn.proiectulMeuSCD.Departament.Department;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="employee")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String email;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Department departmentId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="manager_id")
    private Employee managerId;
}
