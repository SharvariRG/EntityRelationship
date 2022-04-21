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

import com.entity.Passport;
import com.service.PassportService;
import com.utils.NoSuchAccountException;
import com.utils.ResponseModel;

@RestController
@RequestMapping("/api/v1")
public class PassportController {
	@Autowired
	private PassportService passportService;

	@GetMapping("/passports")
	public ResponseEntity<ResponseModel> getAllPassport() {
		try{
			ResponseModel responseModel = new ResponseModel();
		List<Passport> pList = passportService.getAllPassports();
		responseModel.setData(pList);
		responseModel.setMessage("Success");
		return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
	}
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
	}

	@GetMapping("/passport/{id}")
	public ResponseEntity<ResponseModel> getPassport(@PathVariable String id) {
		
		try {
		ResponseModel responseModel=new ResponseModel();
		Passport p=passportService.getPassport(id);
    	
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

	@PostMapping("/passport")
	public ResponseEntity<ResponseModel> addPassport(@RequestBody Passport c) {
		try {
			ResponseModel responseModel=new ResponseModel();
		
			Passport p=passportService.addPassport(c);
			responseModel.setData(p);
	    	responseModel.setMessage("Success");
	    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
	    	}
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
		
	}

	@PutMapping("/passport/{id}")
	public ResponseEntity<ResponseModel> updatePassport(@RequestBody Passport c, @PathVariable String id) {
		try {
			ResponseModel responseModel=new ResponseModel();
		
			Passport p=passportService.updatePassport(c,id);
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

	@DeleteMapping("/passport/{id}")
	public ResponseEntity<ResponseModel> deletePassport(@PathVariable String id) {
		try {
			ResponseModel responseModel=new ResponseModel();
		
			
			responseModel.setData(passportService.deletePassport(id));
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
