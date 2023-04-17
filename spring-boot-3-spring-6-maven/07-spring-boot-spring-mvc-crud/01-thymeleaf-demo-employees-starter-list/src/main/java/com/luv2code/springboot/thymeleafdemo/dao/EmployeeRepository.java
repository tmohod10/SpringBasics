package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!

    // add a method to sort by last name
    // this method name is similar to this query
    // "Select * from employees order by last_name asc"
    // no code to write, all take care by Spring
    public List<Employee> findAllByOrderByLastNameAsc();
	
}
