package com.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Certification {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String certNumber;
	@JsonIgnore
	@ManyToMany(mappedBy = "certification")
	private Set<Employee> emp = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCertNumber() {
		return certNumber;
	}

	public void setCertNumber(String certNumber) {
		this.certNumber = certNumber;
	}

	public void setEmp(Employee employee) {

		emp.add(employee);

	}

	public void removeEmp(Employee employee) {
		emp.remove(employee);

	}

	public Set<Employee> getEmp() {
		return emp;
	}

	public Certification() {
		super();
		// TODO Auto-generated constructor stub
	}

}
