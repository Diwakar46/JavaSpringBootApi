package com.example.Employee.Controller;

import com.example.Employee.Entity.Employee;
import com.example.Employee.services.EmployeeService;
import com.example.Employee.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService; //making object of the interface for loose coupling

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        try {
            EmployeeServiceImpl employeeService1;
            List<Employee> employees = this.employeeService.getEmployees();
            return  ResponseEntity.ok().body(employees);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable String employeeId) {
        try {
           Employee employee = this.employeeService.getEmployee(Long.parseLong(employeeId));
            return ResponseEntity.ok().body(employee);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/employees")
    public ResponseEntity<HttpStatus> addEmployee(@RequestBody Employee employee) {
        try {
            this.employeeService.addEmployee(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employees")
    public ResponseEntity<HttpStatus> updateEmployee(@RequestBody Employee employee) {
        try {
            this.employeeService.updateEmployee(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employees,{employeeId}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String employeeId) {
        try {
            this.employeeService.deleteEmployee(Long.parseLong(employeeId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new
                    ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
