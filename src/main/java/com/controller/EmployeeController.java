package com.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.entity.Employee;
import com.service.EmployeeService;
import com.utils.ResponseModel;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/Employees")
	public ResponseEntity<ResponseModel> getAllEmployees() {
		try{
			ResponseModel responseModel = new ResponseModel();
		List<Employee> employeeList = employeeService.getAllEmployees();
		responseModel.setData(employeeList);
		responseModel.setMessage("Success");
		return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
	}
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
	}

	@GetMapping("/Employees/{EmployeeId}")
	public ResponseEntity<ResponseModel> getEmployee(@PathVariable Long EmployeeId) throws NoSuchElementException {
		
		try {
		ResponseModel responseModel=new ResponseModel();
		Employee employee=employeeService.getEmployee(EmployeeId);
    	
    	responseModel.setData(employee);
    	responseModel.setMessage("Success");
    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found",e);
		} 
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
	}

	@PostMapping("/Employees")
	public ResponseEntity<ResponseModel> addEmployee(@RequestBody Employee c) {
		try {
			ResponseModel responseModel=new ResponseModel();
		
			Employee employee=employeeService.addEmployee(c);
			responseModel.setData(employee);
	    	responseModel.setMessage("Success");
	    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
	    	}
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
		
	}

	@PutMapping("Employees/{id}")
	public ResponseEntity<ResponseModel> updateEmployee(@RequestBody Employee c, @PathVariable Long id) {
		try {
			ResponseModel responseModel=new ResponseModel();
		
			Employee employee=employeeService.updateEmployee(c,id);
			responseModel.setData(employee);
	    	responseModel.setMessage("Success");
	    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
	    	}
		catch(NoSuchElementException e)
		{
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Employee not found",e);
		} 
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
	}

	@DeleteMapping("/Employees/{EmployeeId}")
	public ResponseEntity<ResponseModel> deleteEmployee(@PathVariable Long EmployeeId) {
		try {
			ResponseModel responseModel=new ResponseModel();
		
			
			responseModel.setData(employeeService.deleteEmployee(EmployeeId));
	    	responseModel.setMessage("Success");
	    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
	    	}
		catch(NoSuchElementException e)
		{
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Employee not found",e);
		} 
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
	}
}
