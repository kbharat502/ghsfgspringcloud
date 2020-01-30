package com.bharat.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bharat.msscbreweryclient.web.model.BeerDto;
import com.bharat.msscbreweryclient.web.model.CustomerDto;

@SpringBootTest
public class CustomerClientTest {

	@Autowired
	CustomerClient client;
	
	@Test
	void getCustomerById() {
		CustomerDto dto = client.getCustomerById(UUID.randomUUID());
		assertNotNull(dto);
		
	}
	
	@Test
	void saveNewCustomer() {
		CustomerDto beerDto = CustomerDto.builder().customerName("New Customer").build();
		URI uri = client.saveNewCustomer(beerDto);
		assertNotNull(uri);
		System.out.println(uri);
		
	}
	
	@Test
	void updateCustomer() {
		CustomerDto beerDto = CustomerDto.builder().customerName("New Customer").build();
		client.updateCustomer(UUID.randomUUID(), beerDto);
	}
	
	@Test
	void deleteCustomer() {
		client.deleteCustomer(UUID.randomUUID());
	}
}
