package com.example.system_managemnt.adapters.out;


import com.example.system_managemnt.application.dao.EmployeeDAO;
import com.example.system_managemnt.application.dto.NewEmployeeDto;
import com.example.system_managemnt.adapters.out.entities.EmployeeEntity;
import com.example.system_managemnt.adapters.out.repositories.EmployeesRepository;
import com.example.system_managemnt.domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Component
public class EmployeeDAOAdapter implements EmployeeDAO {

    private final EmployeesRepository employeesRepository;
    @Override
    public Optional<Employee> findEmployeeByName(String name){
        return employeesRepository.findEmployeeByName(name);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return ((List<EmployeeEntity>) employeesRepository.findAll())
                .stream()
                .map(employeeEntity -> new Employee(
                        employeeEntity.id(),
                        employeeEntity.firstName(),
                        employeeEntity.lastName(),
                        employeeEntity.email(),
                        employeeEntity.salary()

                )).toList();
    }
    @Override
    public void saveEmployee(NewEmployeeDto newEmployeeDto) {
        employeesRepository.save(
                new EmployeeEntity(
                        null,
                        (String) newEmployeeDto.getfirstName(),
                        (String) newEmployeeDto.getlastName(),
                        (String) newEmployeeDto.getemail(),
                        (Integer) newEmployeeDto.getsalary()
                )
        );
    }

    @Override
    public void updateEmployee(Employee newEmployee) {

    }


    @Override
    public void updateEmployee (Employee newEmployee , NewEmployeeDto newEmployeeDto){
        employeesRepository.save(
                new EmployeeEntity(
                        newEmployee.id(),
                        (String) newEmployeeDto.getfirstName(),
                        (String) newEmployeeDto.getlastName(),
                        (String) newEmployeeDto.getemail(),
                        (Integer) newEmployeeDto.getsalary()
                )
        );
    }
    @Override
    public void deleteEmployee (Employee oldEmployee){
        employeesRepository.deleteById(Long.valueOf(oldEmployee.id()));
    }

}
