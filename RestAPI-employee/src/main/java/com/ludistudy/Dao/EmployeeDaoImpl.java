package com.ludistudy.Dao;

import com.ludistudy.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee>  query = entityManager.createQuery("From Employee ", Employee.class);

        // execute and return list of Employee
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        System.out.println("finding employee with ID : "+ id);
        Employee employee = entityManager.find(Employee.class, id);
        System.out.println("found Employee : "+ employee);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        System.out.println("saving an employee");
        Employee dbEmployee = entityManager.merge(employee);
        System.out.println("saved Employee: "+ dbEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        System.out.println("deleting an employee");

        entityManager.remove(findById(id));
    }
}
