package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.repo.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	@Autowired

	public EmployeeRepository repo;
	private static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	public Employee getEmployee(Long EmployeeId) {
		Employee a = repo.findById(EmployeeId).orElseThrow();
		logger.info("Employee {}", a);
		return a;

	}

	public Employee addEmployee(Employee c) {

		return repo.save(c);

	}

	public Employee updateEmployee(Employee c, Long id) {
		getEmployee(id);
		// Employee employee = getEmployee(id);
		// Employee newEmp = new Employee();

		/*
		 * if (employee != null) { newEmp.setId(id); newEmp.setName(c.getName());
		 * newEmp.setPassport(employee.getPassport());
		 * newEmp.setAddress(employee.getAddress());
		 * newEmp.setCertification(employee.getCertification()); // pass list
		 * 
		 * // pass object not list //
		 * employee.getAddress().forEach(i->newEmp.setAddress(i)); //
		 * employee.getCertification().forEach(i->newEmp.setCertification(i));
		 * 
		 * return repo.save(newEmp); } throw new NoSuchElementException(":" + id);
		 */
		c.setId(id);
		return repo.save(c);
	}

	public Employee deleteEmployee(Long EmployeeId) {
		Employee a = getEmployee(EmployeeId);
		repo.deleteById(EmployeeId);
		return a;

	}

}
