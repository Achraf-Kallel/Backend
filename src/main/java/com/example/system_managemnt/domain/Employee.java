package com.example.system_managemnt.domain;

public record Employee(
        Integer id,
        String firstName,
        String lastName,
        String email,
        Integer salary
) {

}
