package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Address;
import com.entity.Certification;

public interface CertificationRepository extends JpaRepository<Certification,Long>{

}


