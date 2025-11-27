package com.example.crudoperation.demo.service;


import com.example.crudoperation.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

        Employee saveEmployee(Employee employee);
        Employee getEmployeeById(Long id);
        List<Employee> getAllEmployee();
        void deleteEmployee(Long id);
        Employee updateEmployee(Long id, Employee employee);
        Employee updatePartial(Long id, Employee employee);
}
