package com.bharat.msscbrewery.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bharat.msscbrewery.services.CustomerService;
import com.bharat.msscbrewery.web.model.CustomerDto;

@Validated
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomerById(@NotNull @PathVariable("customerId") UUID customerId) {
		return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> handlePost(@Valid @RequestBody CustomerDto customerDto) {
		CustomerDto saveNewCustomer = customerService.saveNewCustomer(customerDto);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/customer/" + saveNewCustomer.getId());
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<?> handlePut(@PathVariable("customerId") UUID customerId, @Valid @NotNull @RequestBody CustomerDto customerDto) {
		customerService.updateCustomer(customerId, customerDto);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("customerId") UUID customerId) {
		customerService.deleteById(customerId);
	}
	
	/*
	 * @ExceptionHandler(ConstraintViolationException.class) public
	 * ResponseEntity<List<String>>
	 * validationErrorHandler(ConstraintViolationException e) { List<String> errors
	 * = new ArrayList<String>(e.getConstraintViolations().size());
	 * e.getConstraintViolations().forEach(constraintViolation -> {
	 * errors.add(constraintViolation.getPropertyPath() + " " +
	 * constraintViolation.getMessage()); });
	 * 
	 * return new ResponseEntity<List<String>>(errors, HttpStatus.BAD_REQUEST); }
	 */
}
