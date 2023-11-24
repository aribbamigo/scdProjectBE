package com.utcn.proiectulMeuSCD.Departament;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.utcn.proiectulMeuSCD.Employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String description;


    @JsonBackReference
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="parentid_id")
    private Department parentID;
}
