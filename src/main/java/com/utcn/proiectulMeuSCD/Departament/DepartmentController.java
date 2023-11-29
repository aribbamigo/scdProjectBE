package com.utcn.proiectulMeuSCD.Departament;

import com.utcn.proiectulMeuSCD.DTO.DepartmentBasic;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping(value = "/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(value="/getAllDepartments")
    public List<DepartmentBasic> allDepartments() {
        return departmentService.getAllDepartments();
    }
    
    @GetMapping(value="/getDepartment")
    public DepartmentBasic getDepartmentService(@PathParam("id") Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PutMapping(value = "/updateDepartment/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateDepartment(@PathVariable("id") Long id, @RequestBody DepartmentBasic department) {
        departmentService.updateDepartment(id, department);
        return new ResponseEntity<>("Updated!", HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteDepartment/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>("Deleted!", HttpStatus.OK);
    }

    @PostMapping(value="/createDepartment")
    public ResponseEntity<String> createDepartment(@RequestBody DepartmentBasic department) {
        departmentService.createDepartment(department);
        return new ResponseEntity<>("Created!", HttpStatus.OK);
    }
    
}
