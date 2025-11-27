package com.example.crudoperation.demo.repository;

import com.example.crudoperation.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
