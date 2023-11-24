package com.utcn.proiectulMeuSCD.Departament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    Department findById(Long id);

    void deleteById(Long id);
}
