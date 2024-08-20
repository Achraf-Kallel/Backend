package com.example.system_managemnt.application.dao;

import com.example.system_managemnt.application.dto.NewEmployeeDto;
import com.example.system_managemnt.domain.Employee;

import java.util.List;
import java.util.Optional;


public interface EmployeeDAO {
    Optional<Employee> findEmployeeByName(String firstName);

    List<Employee> findAllEmployees();

    void saveEmployee (NewEmployeeDto employee);

    void updateEmployee(Employee newEmployee);

    void updateEmployee(Employee newEmployee, NewEmployeeDto newEmployeeDto);

    void deleteEmployee (Employee oldEmployee);



}
