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

    @Query(value="select e from employee e where e.id = :id")
    Employee findEmployeeById(@Param("id") Long id);

    void deleteById(Long id);

    @Query(value="select e from employee e")
    List<Employee> findAllEmployees();

}
