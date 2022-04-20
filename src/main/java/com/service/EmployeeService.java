package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.repo.EmployeeRepository;
import com.utils.NoSuchAccountException;

@Service
@Transactional
public class EmployeeService {

	@Autowired

	public EmployeeRepository repo;

	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	public Employee getEmployee(Long EmployeeId) {
		return repo.findById(EmployeeId).get();
	}

	public Employee addEmployee(Employee c) {

		return repo.save(c);

	}

	public Employee updateEmployee(Employee c, Long id) {
		Employee employee = getEmployee(id);
		Employee newEmp = new Employee();

		if (employee != null) {
			newEmp.setId(id);
			newEmp.setName(c.getName());
			newEmp.setPassport(employee.getPassport());
			newEmp.setAddress(employee.getAddress());
			newEmp.setCertification(employee.getCertification());
			// pass list

			// pass object not list
			// employee.getAddress().forEach(i->newEmp.setAddress(i));
			// employee.getCertification().forEach(i->newEmp.setCertification(i));

			return repo.save(newEmp);
		}
		throw new NoSuchAccountException(":" + id);

	}

	public Employee updateEmployee(Employee c) {
		return repo.save(c);

	}

	public void deleteEmployee(Long EmployeeId) {
		repo.deleteById(EmployeeId);

	}

}
