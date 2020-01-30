package com.bharat.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bharat.msscbreweryclient.web.model.BeerDto;

@SpringBootTest
public class BreweryClientTest {

	@Autowired
	BreweryClient client;
	
	@Test
	void getBeerById() {
		BeerDto dto = client.getBeerById(UUID.randomUUID());
		assertNotNull(dto);
		
	}
	
	@Test
	void saveNewBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		URI uri = client.saveNewBeer(beerDto);
		assertNotNull(uri);
		System.out.println(uri);
		
	}
	
	@Test
	void updateBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		client.updateBeer(UUID.randomUUID(), beerDto);
	}
	
	@Test
	void deleteBeer() {
		client.deleteBeer(UUID.randomUUID());
	}
}
