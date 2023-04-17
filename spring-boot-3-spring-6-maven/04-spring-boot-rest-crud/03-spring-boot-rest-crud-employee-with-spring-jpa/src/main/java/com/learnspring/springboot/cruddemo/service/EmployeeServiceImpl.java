package com.learnspring.springboot.cruddemo.service;

import com.learnspring.springboot.cruddemo.dao.EmployeeRepository;
import com.learnspring.springboot.cruddemo.entity.Employee;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    // no need to add @Transactional as JPARepository provides this functionality
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        // Getting the data without explicitly checking for NULL
        Employee theEmployee = null;
        if (result.isPresent() == true) {
            theEmployee = result.get();
        } else {
            // value wasn't present
            throw new RuntimeException("Did not find employee id: " + theId);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
