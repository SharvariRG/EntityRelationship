package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Address;
import com.entity.Certification;
import com.entity.Passport;
import com.repo.AddressRepository;
import com.repo.CertificationRepository;
import com.repo.PassportRepository;
import com.utils.NoSuchAccountException;

@Service
@Transactional
public class CertificationService {

	@Autowired

	public CertificationRepository repo;

	public List<Certification> getAllCertification() {
		return repo.findAll();
	}

	public Certification getCertification(Long id) {
		Certification a= repo.findById(id).orElseThrow();
		return a;
	}

	public Certification addCertification(Certification c) {

		return repo.save(c);

	}

	public Certification updateCertification(Certification c, Long id) {

		getCertification(id) ;
			c.setId(id);
			return repo.save(c);
		

	}

	public Certification deleteCertification(Long Id) {
		Certification a=getCertification(Id);

		
			 repo.deleteById(Id);
			 return a;
		

	}



}
