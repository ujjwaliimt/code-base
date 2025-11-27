package com.example.crudoperation.demo.serviceimpl;


import com.example.crudoperation.demo.entity.Employee;
import com.example.crudoperation.demo.repository.EmployeeRepository;
import com.example.crudoperation.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo){
        this.repo=repo;
    }

    @Override
    public Employee saveEmployee(Employee employee){
        return repo.save(employee);
    }
    @Override
    public Employee getEmployeeById(Long id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployee(){
        return repo.findAll();
    }
    @Override
    public void deleteEmployee(Long id){
        repo.deleteById(id);
    }
    @Override
    public Employee updateEmployee(Long id, Employee employee){
        Employee existing=repo.findById(id).orElse(null);
        if (existing!=null) {
            existing.setName(employee.getName());
            existing.setEmail(employee.getEmail());
            existing.setSalary(employee.getSalary());
            return repo.save(existing);
        }
        return null;
    }

    @Override
    public Employee updatePartial(Long id, Employee updates){
        Employee existing=repo.findById(id).orElse(null);
        if(existing!=null){
            if (updates.getName()!=null){
                existing.setName(updates.getName());
            }
            if (updates.getEmail()!=null){
                existing.setEmail(updates.getEmail());
            }
            if (updates.getSalary()!=0){
                existing.setSalary(updates.getSalary());
            }
            return repo.save(existing);
        }

        return null;
    }


}
