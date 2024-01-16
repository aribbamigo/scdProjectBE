package com.utcn.proiectulMeuSCD.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeById(@Param("id") Long id);

    void deleteById(Long id);

    List<Employee> getAllByManagerId(Long id);

    List<Employee> findAllByDepartmentId(Long id);

    @Query("select distinct e.manager from employee e" +
            " where e.department.id = :id")
    List<Employee> findAllManagersByDepartment(Long id);
}
