package com.ludistudy.Dao;

import com.ludistudy.Entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save (Employee employee);

    void deleteById (int id);
}
