package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.entity.Certification;
import com.service.CertificationService;
import com.utils.NoSuchAccountException;
import com.utils.ResponseModel;

@RestController
@RequestMapping("/api/v1")
public class CertificationController {
	@Autowired
	private CertificationService certificationService;

	@GetMapping("/certifications")
	public ResponseEntity<ResponseModel> getAllCertification() {
		try{
			ResponseModel responseModel = new ResponseModel();
		List<Certification> list = certificationService.getAllCertification();
		responseModel.setData(list);
		responseModel.setMessage("Success");
		return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
	}
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
	}

	@GetMapping("/certification/{id}")
	public ResponseEntity<ResponseModel> getCertification(@PathVariable Long id) {
		
		try {
		ResponseModel responseModel=new ResponseModel();
		Certification p=certificationService.getCertification(id);
    	
    	responseModel.setData(p);
    	responseModel.setMessage("Success");
    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
		}
		catch(NoSuchAccountException e)
		{
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Account not found",e);
		} 
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
	}

	@PostMapping("/certification")
	public ResponseEntity<ResponseModel> addCertification(@RequestBody Certification c) {
		try {
			ResponseModel responseModel=new ResponseModel();
		
			Certification p=certificationService.addCertification(c);
			responseModel.setData(p);
	    	responseModel.setMessage("Success");
	    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
	    	}
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
		
	}

	@PutMapping("/certification/{id}")
	public ResponseEntity<ResponseModel> updateCertification(@RequestBody Certification c, @PathVariable Long id) {
		try {
			ResponseModel responseModel=new ResponseModel();
		
			Certification p=certificationService.updateCertification(c,id);
			responseModel.setData(p);
	    	responseModel.setMessage("Success");
	    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
	    	}
		catch(NoSuchAccountException e)
		{
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Account not found",e);
		} 
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
	}

	@DeleteMapping("/certification/{id}")
	public ResponseEntity<ResponseModel> deleteCertification(@PathVariable Long id) {
		try {
			ResponseModel responseModel=new ResponseModel();
		
			
			responseModel.setData(certificationService.deleteCertification(id));
	    	responseModel.setMessage("Success");
	    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
	    	}
		catch(NoSuchAccountException e)
		{
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Account not found",e);
		} 
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
	}
}
