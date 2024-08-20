package com.example.system_managemnt;

import com.example.system_managemnt.domain.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

	@Test
	void testEmployeeCreation() {
		// Create an Employee object
		Employee employee = new Employee(1, "achraf", "kallel", "achrafkallel58@gmail.com", 1000);

		// Test that the fields are correctly set
		assertEquals(1, employee.id());
		assertEquals("achraf", employee.firstName());
		assertEquals("kallel", employee.lastName());
		assertEquals("achrafkallel58@gmail.com", employee.email());
		assertEquals(1000, employee.salary());
	}
}
