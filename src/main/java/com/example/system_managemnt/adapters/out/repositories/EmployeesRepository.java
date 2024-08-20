package com.example.system_managemnt.adapters.out.repositories;

import com.example.system_managemnt.adapters.out.entities.EmployeeEntity;
import com.example.system_managemnt.domain.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeesRepository extends CrudRepository<EmployeeEntity,  Long> {
    //table name = employeees
   @Query("select * from employeees where firstName =: firstName")
    Optional<Employee> findEmployeeByName( @Param("firstName") String firstName);
}
