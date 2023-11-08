package com.ludistudy.Dao;

import com.ludistudy.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that is it .. no need to write code
}
