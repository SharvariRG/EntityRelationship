package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport,String>{

}
