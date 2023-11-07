package com.ludistudy.Controller;

import com.ludistudy.Entity.Employee;
import com.ludistudy.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/api")
public class EmployeeController {

    private EmployeeService employeeService;

    // inject EmployeeService
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        System.out.println("Retrieving all Employees...");
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeesId}")
    public Employee findOneEmployees(@PathVariable int employeesId){
        System.out.println("Retrieving one Employees...");
        Employee employee = employeeService.findById(employeesId);

        if(employee == null){
            throw new RuntimeException("Employee id not found - "+ employeesId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        System.out.println("creating one Employees...");

        employee.setId(0);

        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        if (employeeService.findById(employeeId)==null){
            throw new RuntimeException("not found id - "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id - " +employeeId;
    }
}
