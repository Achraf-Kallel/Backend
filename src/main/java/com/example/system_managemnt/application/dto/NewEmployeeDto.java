package com.example.system_managemnt.application.dto;

public record NewEmployeeDto(
        Integer id,
        String firstName,
        String lastName,
        String email,
        Integer salary
) {
    public Object getid() {return id;}
    public Object getfirstName() {return firstName;}
    public Object getlastName() {
        return lastName;
    }
    public Object getemail() {
        return email;
    }
    public Object getsalary() {
        return salary;
    }


    public void setid(int i) {
    }
    public void setfirstName(String achraf) {
    }
    public void setlastName(String kallel) {
    }
    public void setemail(String mail) {
    }
    public void setsalary(int i) {
    }

}
