package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/Employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();

	}

	@GetMapping("/Employees/{EmployeeId}")
	public Employee getEmployee(@PathVariable Long EmployeeId) {
		return employeeService.getEmployee(EmployeeId);
	}

	@PostMapping("/Employees")
	public Employee addEmployee(@RequestBody Employee c) {
		return employeeService.addEmployee(c);
	}

	@PutMapping("Employees/{EmployeeId}")
	public Employee updateEmployee(@RequestBody Employee c, @PathVariable Long id) {
		return employeeService.updateEmployee(c);
	}

	@DeleteMapping("/Employees/{EmployeeId}")
	public void deleteEmployee(@PathVariable Long EmployeeId) {
		employeeService.deleteEmployee(EmployeeId);
	}
}
