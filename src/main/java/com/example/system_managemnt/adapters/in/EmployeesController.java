package com.example.system_managemnt.adapters.in;


import com.example.system_managemnt.application.dto.NewEmployeeDto;
import com.example.system_managemnt.application.usecases.EmployeeUseCase;
import com.example.system_managemnt.domain.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeesController {

    private final EmployeeUseCase employeeUseCase;

    @GetMapping
    public ResponseEntity<?> getAllEmployees(){
        return ResponseEntity.ok(employeeUseCase.getAllEmployees());
    }

    @GetMapping("/{First_Name}")
    public ResponseEntity<?> getEmployeeByName(@PathVariable("First_Name") String First_Name){
        return ResponseEntity.ok(employeeUseCase.getEmployeeByName(First_Name));
    }

    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody NewEmployeeDto newEmployeeDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeUseCase.saveEmployee(newEmployeeDto));
    }

    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeUseCase.updateEmployee(employee));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@RequestBody Employee employee) {
        employeeUseCase.deleteEmployee(employee);
        return ResponseEntity.noContent().build();
    }




}
