package com.example.crudoperation.demo.controller;

import com.example.crudoperation.demo.entity.Employee;
import com.example.crudoperation.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service=service;
    }

    @PostMapping("/create")
    public Employee saveEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @GetMapping("/fetchEmpById/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return service.getEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return service.updateEmployee(id, employee);
    }

    @PatchMapping("/partialUpdate/{id}")
    public Employee updatePartial(@PathVariable Long id, @RequestBody Employee employee){
        return service.updatePartial(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
        return "Employee has been deleted successfully";
    }

}
