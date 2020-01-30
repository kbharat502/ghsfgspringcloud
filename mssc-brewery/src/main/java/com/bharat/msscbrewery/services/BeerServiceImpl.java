package com.bharat.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bharat.msscbrewery.web.model.BeerDto;

@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID beerId) {
		return BeerDto.builder().id(UUID.randomUUID())
				.beerName("Galaxy Cat")
				.beerStyle("Pale Ale")
				.build();
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		return BeerDto.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void updateBeer(UUID beerId, BeerDto beerDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBeer(UUID beerId) {
		System.out.println("Deleting beer...");
		
	}

}
