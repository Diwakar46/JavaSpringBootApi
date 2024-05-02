package com.example.Employee.services;

import com.example.Employee.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public List<Employee> employeeList;

    public EmployeeServiceImpl() {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "aca", "acba", 18, "admin"));

    }

    @Override
    //Method for getting all employees
    public List<Employee> getEmployees() {
        return employeeList;
    }

    @Override
    //Method for getting employees by id
    public Employee getEmployee(long employeeId) {
        Employee employee = null;
        for (Employee emp : employeeList) {
            if (emp.getId() == employeeId) {
                employee = emp;
                break;
            }
        }
        return employee;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeList.add(employee);

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        employeeList.forEach(e -> {
            if (e.getId() == employee.getId()) {
                e.setFirstName(employee.getFirstName());
                e.setLastName(employee.getLastName());
                e.setAge(employee.getAge());
                e.setRole(employee.getRole());
            }
        });
        return employee;
    }

    @Override
    public void deleteEmployee(long employeeId) {
        employeeList = this.employeeList.stream().filter(e -> e.getId() != employeeId).collect(Collectors.toList());
    }
}
