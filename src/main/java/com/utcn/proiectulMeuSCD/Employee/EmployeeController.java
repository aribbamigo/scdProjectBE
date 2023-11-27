package com.utcn.proiectulMeuSCD.Employee;

import com.utcn.proiectulMeuSCD.DTO.EmployeeBasic;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(value = "/getAllEmployees")
    public List<EmployeeBasic> allEmployees() {
        return employeeService.getAllEmployees();
    }

//    @GetMapping(value="/getEmployee")
//    public EmployeeBasic getEmployeeService() {
//        return employeeService.ge;
//    }

    @PutMapping(value = "/updateEmployee/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeBasic employee) {
        employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>("Updated!", HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Deleted!", HttpStatus.OK);
    }

    @PostMapping(value="/createEmployee")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeBasic employee) {
        employeeService.createEmployee(employee);
        return new ResponseEntity<>("Created!", HttpStatus.OK);
    }
}
