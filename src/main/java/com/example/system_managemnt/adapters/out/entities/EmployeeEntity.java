package com.example.system_managemnt.adapters.out.entities;


import jakarta.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;



@Entity
@Table(name="employees")
public record EmployeeEntity(
        @Id
        Integer id,
        String firstName,
        String lastName,
        String email,
        Integer salary,


        @Version
        Integer version
) {
        public EmployeeEntity(Integer id, String firstName, String lastName, String email,  Integer salary) {
                this(id, firstName, lastName, email, salary, 0);
        }
}
