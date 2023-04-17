package com.learnspring.springboot.cruddemo.dao;

import com.learnspring.springboot.cruddemo.entity.Employee;
import com.learnspring.springboot.cruddemo.service.EmployeeService;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
