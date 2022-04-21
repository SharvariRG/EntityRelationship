package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Passport;
import com.repo.PassportRepository;

@Service
@Transactional
public class PassportService {

	@Autowired

	public PassportRepository repo;

	public List<Passport> getAllPassports() {
		return repo.findAll();
	}

	public Passport getPassport(String id) {
		Passport a = repo.findById(id).orElseThrow();
		return a;
	}

	public Passport addPassport(Passport c) {

		return repo.save(c);

	}

	public Passport updatePassport(Passport c, String id) {

		getPassport(id);
		c.setNumber(id);
		return repo.save(c);

	}

	public Passport deletePassport(String PassportId) {

		Passport a = getPassport(PassportId);

		repo.deleteById(PassportId);
		return a;

	}

}
