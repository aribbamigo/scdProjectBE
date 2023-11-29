package com.utcn.proiectulMeuSCD.DTO;

import com.utcn.proiectulMeuSCD.Departament.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentBasic {
    private Long id;

    private String description;

    private Long parentId;

    public DepartmentBasic(Department department) {
        this.id = department.getId();
        this.description = department.getDescription();
        this.parentId = department.getParent() != null ? department.getParent().getId() : this.id;
    }

}
