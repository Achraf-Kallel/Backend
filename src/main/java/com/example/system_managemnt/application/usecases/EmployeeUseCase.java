package com.example.system_managemnt.application.usecases;
import com.example.system_managemnt.infrastructure.exceptions.EmployeeAlreadyExistsException;
import com.example.system_managemnt.infrastructure.exceptions.EmployeeNotFoundException;


import com.example.system_managemnt.application.dao.EmployeeDAO;
import com.example.system_managemnt.application.dto.NewEmployeeDto;
import com.example.system_managemnt.domain.Employee;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeUseCase {
    private final EmployeeDAO employeeDAO;

    public String saveEmployee(NewEmployeeDto newemployeedto) throws EmployeeAlreadyExistsException {
        var isPresent = employeeDAO.findEmployeeByName(newemployeedto.firstName()).isPresent();
        //check if employee  already exists
        if (isPresent) {
            throw new EmployeeAlreadyExistsException("Employee already exists");
        }
        //else save it to the database
        employeeDAO.saveEmployee(newemployeedto);
        return "Employee saved successfully";
    }
    public List<Employee> getAllEmployees(){
            return employeeDAO.findAllEmployees();
        }

    public String updateEmployee(Employee employee) throws EmployeeNotFoundException {

        var isPresent = employeeDAO.findEmployeeByName(employee.firstName()).isPresent();
        if (!isPresent) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        employeeDAO.updateEmployee(employee);
        return "Employee updated successfully";
    }
    public Employee getEmployeeByName(String employeeName){
        return employeeDAO.findEmployeeByName(employeeName).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found"));
    }
    public void deleteEmployee(Employee employee) throws EmployeeNotFoundException {
        var isPresent = employeeDAO.findEmployeeByName(employee.firstName()).isPresent();
        //if employee does not exist log error message
        if (!isPresent) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        //else delete
        employeeDAO.deleteEmployee(employee);
    }

}



