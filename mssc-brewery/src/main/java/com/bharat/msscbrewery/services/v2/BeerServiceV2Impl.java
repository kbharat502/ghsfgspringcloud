package com.bharat.msscbrewery.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bharat.msscbrewery.web.model.v2.BeerDtoV2;
import com.bharat.msscbrewery.web.model.v2.BeerStyleEnum;

@Service
public class BeerServiceV2Impl implements BeerServiceV2 {

	@Override
	public BeerDtoV2 getBeerById(UUID beerId) {
		return BeerDtoV2.builder().id(UUID.randomUUID())
				.beerName("Galaxy Cat")
				.beerStyle(BeerStyleEnum.PALE_ALE)
				.build();
	}

	@Override
	public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
		return BeerDtoV2.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBeer(UUID beerId) {
		System.out.println("Deleting beer...");
		
	}

}
