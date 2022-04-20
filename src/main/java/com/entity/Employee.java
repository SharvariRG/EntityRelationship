package com.entity;

<<<<<<< HEAD
import java.util.HashSet;
import java.util.Set;

=======
>>>>>>> c2194ce025a91c52ae5b2da9cf2fb991c7fe536a
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
=======
>>>>>>> c2194ce025a91c52ae5b2da9cf2fb991c7fe536a
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Passport passport;
<<<<<<< HEAD
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToMany(cascade=CascadeType.ALL,mappedBy="employee")
	private Set<Address> address = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Certification> certification = new HashSet<>();

	
	public Employee() {
	}

	public Employee(Long id, String name, Passport passport) {
		super();
		this.id = id;
		this.name = name;
		this.passport = passport;
		
=======

	protected Employee() {
>>>>>>> c2194ce025a91c52ae5b2da9cf2fb991c7fe536a
	}

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public Long getId() {
		return id;
	}
<<<<<<< HEAD
	
	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * public void setAddress(Address add){
	 * 
	 * address.add(add); add.setEmployee(this); } public void removeAddress(Address
	 * add){ address.remove(add); add.setEmployee(null); }
	 */
     
    public Set<Address> getAddress() { return address; }
    
    
    
    
	/*
	 * public void setCertification(Certification idp){
	 * 
	 * certification.add(idp); idp.setEmp(this); } public void
	 * removeCertification(Certification idp){ certification.remove(idp);
	 * idp.setEmp(null); }
	 */
     
    public Set<Certification> getCertification() { return certification; }
    

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public void setCertification(Set<Certification> certification) {
		this.certification = certification;
	}

	@Override
	public String toString() {
		return String.format("Employee[%s]", name);
=======

	@Override
	public String toString() {
		return String.format("Student[%s]", name);
>>>>>>> c2194ce025a91c52ae5b2da9cf2fb991c7fe536a
	}
}