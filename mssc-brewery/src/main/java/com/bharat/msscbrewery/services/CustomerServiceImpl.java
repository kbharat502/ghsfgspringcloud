package com.bharat.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bharat.msscbrewery.web.model.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		return CustomerDto.builder().id(UUID.randomUUID())
				.customerName("Customer1")
				.build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		return CustomerDto.builder().id(UUID.randomUUID()).build();
		
	}

	@Override
	public void updateCustomer(UUID customerId, CustomerDto customerDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(UUID customerId) {
		// TODO Auto-generated method stub
		
	}

}
