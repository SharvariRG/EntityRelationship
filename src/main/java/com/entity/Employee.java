package com.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Passport passport;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	private Set<Address> addressList = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Certification> certification = new HashSet<>();

	public Employee() {
	}

	public Employee(Long id, String name, Passport passport) {
		super();
		this.id = id;
		this.name = name;
		this.passport = passport;
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
		passport.setEmployee(this);
		this.passport = passport;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * public void setAddress(Address add){
	 * 
	 * address.add(add); add.setEmployee(this); } public void removeAddress(Address
	 * add){ address.remove(add); add.setEmployee(null); }
	 */
	/*
	 * public void addAddress(Address address) { if (addressList == null) {
	 * addressList = new HashSet<>(); } address.setEmployee(this);
	 * addressList.add(address); }
	 */
	public Set<Address> getAddress() {
		return addressList;
	}

	/*
	 * public void setCertification(Certification idp){
	 * 
	 * certification.add(idp); idp.setEmp(this); } public void
	 * removeCertification(Certification idp){ certification.remove(idp);
	 * idp.setEmp(null); }
	 */

	public Set<Certification> getCertification() {
		return certification;
	}

	public void setAddress(Set<Address> addresslist) {
		addresslist.forEach(a -> a.setEmployee(this));
		this.addressList = addresslist;

	}

	public void setCertification(Set<Certification> certification) {
		certification.forEach(a -> a.setEmp(this));
		this.certification = certification;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", passport=" + passport + ", addressList=" + addressList
				+ ", certification=" + certification + "]";
	}

}