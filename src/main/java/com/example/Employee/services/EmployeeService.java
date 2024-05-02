package com.example.Employee.services;
import  java.util.*;
import com.example.Employee.Entity.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

     List<Employee> getEmployees();
     Employee getEmployee(long employeeId);
     void addEmployee(Employee employee);
     Employee updateEmployee(Employee employee);
     void deleteEmployee(long employeeId );
}
