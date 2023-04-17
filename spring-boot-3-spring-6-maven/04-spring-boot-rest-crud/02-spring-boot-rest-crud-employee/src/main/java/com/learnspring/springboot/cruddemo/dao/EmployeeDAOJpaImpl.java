package com.learnspring.springboot.cruddemo.dao;

import com.learnspring.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // setup constructor injection
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute the query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the result
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // get employee
        Employee employee = entityManager.find(Employee.class, theId);

        // return employee
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // save employee
        // if id == 0 then save/insert else update
        Employee dbEmployee = entityManager.merge(theEmployee);

        // return the latest updated dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // find employee by id
        Employee employee = entityManager.find(Employee.class, theId);

        // remove employee
        entityManager.remove(employee);
    }
}
