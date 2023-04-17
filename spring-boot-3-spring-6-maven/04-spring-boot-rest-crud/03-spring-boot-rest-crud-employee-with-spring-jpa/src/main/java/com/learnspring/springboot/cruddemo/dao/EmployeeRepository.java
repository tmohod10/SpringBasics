package com.learnspring.springboot.cruddemo.dao;

import com.learnspring.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// <Entity Type, Primary Key>
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's it ... no need to write any code.
    // now we can access all the CRUD method for FREE
    // such as findAll(), findById(), save(), deleteById(), ...
}
