package com.bharat.msscbrewery.web.mappers;

import org.mapstruct.Mapper;

import com.bharat.msscbrewery.domain.Customer;
import com.bharat.msscbrewery.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {

	CustomerDto customerToCustomerDto(Customer customer);
	
	Customer customerDtoToCustomer(CustomerDto customerDto);
}
