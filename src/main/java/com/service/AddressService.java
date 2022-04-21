package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Address;
import com.repo.AddressRepository;

@Service
@Transactional
public class AddressService {

	@Autowired

	public AddressRepository repo;

	public List<Address> getAllAddress() {
		return repo.findAll();
	}

	public Address getAddress(Long id) {
		Address a = repo.findById(id).orElseThrow();
		return a;

	}

	public Address addAddress(Address c) {

		return repo.save(c);

	}

	public Address updateAddress(Address c, Long id) {

		getAddress(id);
		c.setId(id);
		return repo.save(c);

	}

	public Address deleteAddress(Long addressId) {
		Address a = getAddress(addressId);

		repo.deleteById(addressId);
		return a;
	}

}
