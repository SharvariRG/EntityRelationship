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

import com.entity.Address;
import com.service.AddressService;
import java.util.NoSuchElementException;
import com.utils.ResponseModel;

@RestController
@RequestMapping("/api/v1")
public class AddressController {
	@Autowired
	private AddressService addressService;

	@GetMapping("/address")
	public ResponseEntity<ResponseModel> getAllAddress() {
		try{
			ResponseModel responseModel = new ResponseModel();
		List<Address> addressList = addressService.getAllAddress();
		responseModel.setData(addressList);
		responseModel.setMessage("Success");
		return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
	}
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
	}

	@GetMapping("/address/{id}")
	public ResponseEntity<ResponseModel> getAddress(@PathVariable Long id) {
		
		try {
		ResponseModel responseModel=new ResponseModel();
		Address ad=addressService.getAddress(id);
    	
    	responseModel.setData(ad);
    	responseModel.setMessage("Success");
    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Address Not Found",e);
		} 
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
	}

	@PostMapping("/address")
	public ResponseEntity<ResponseModel> addAddress(@RequestBody Address c) {
		try {
			ResponseModel responseModel=new ResponseModel();
		
			Address add=addressService.addAddress(c);
			responseModel.setData(add);
	    	responseModel.setMessage("Success");
	    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
	    	}
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
		
	}

	@PutMapping("/address/{id}")
	public ResponseEntity<ResponseModel> updateAddress(@RequestBody Address c, @PathVariable Long id) {
		try {
			ResponseModel responseModel=new ResponseModel();
		
			Address add=addressService.updateAddress(c,id);
			responseModel.setData(add);
	    	responseModel.setMessage("Success");
	    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
	    	}
		catch(NoSuchElementException e)
		{
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Address Not Found",e);
		} 
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
	}

	@DeleteMapping("/address/{id}")
	public ResponseEntity<ResponseModel> deleteAddress(@PathVariable Long id) {
		try {
			ResponseModel responseModel=new ResponseModel();
		
			
			responseModel.setData(addressService.deleteAddress(id));
	    	responseModel.setMessage("Success");
	    	return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
	    	}
		catch(NoSuchElementException e)
		{
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Address Not Found",e);
		} 
		catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!",e);
		} 
	}
}
