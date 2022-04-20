package com.service;

<<<<<<< HEAD
import java.util.HashSet;
import java.util.List;
import java.util.Set;
=======
import java.util.List;
>>>>>>> c2194ce025a91c52ae5b2da9cf2fb991c7fe536a

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.entity.Address;
import com.entity.Employee;
import com.repo.EmployeeRepository;
import com.utils.NoSuchAccountException;
=======
import com.entity.Employee;
import com.repo.EmployeeRepository;
>>>>>>> c2194ce025a91c52ae5b2da9cf2fb991c7fe536a

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
<<<<<<< HEAD
		
		return repo.save(c);
		
	}
 
	public Employee updateEmployee(Employee c,Long id) {
		Employee employee=getEmployee(id);
		Employee newEmp=new Employee();
		
		if(employee!=null)
		{
			newEmp.setId(id);
			newEmp.setName(c.getName());
			newEmp.setPassport(employee.getPassport());
			newEmp.setAddress(employee.getAddress());
			newEmp.setCertification(employee.getCertification());
			//pass list
			
			
			//pass object not list
			//employee.getAddress().forEach(i->newEmp.setAddress(i));
			//employee.getCertification().forEach(i->newEmp.setCertification(i));
        
		
		return repo.save(newEmp);
		}
		throw new NoSuchAccountException(":"+id);
=======
		return repo.save(c);
		
	}

	public Employee updateEmployee(Employee c) {
		return repo.save(c);
>>>>>>> c2194ce025a91c52ae5b2da9cf2fb991c7fe536a
		
	}

	public void deleteEmployee(Long EmployeeId) {
		 repo.deleteById(EmployeeId);
		
	}
	
	
	
	

	
	
}
