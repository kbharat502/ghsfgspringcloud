package com.bharat.msscbrewery.web.mappers;

import org.mapstruct.Mapper;

import com.bharat.msscbrewery.domain.Beer;
import com.bharat.msscbrewery.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

	BeerDto beerToBeerDto(Beer beer);
	
	Beer beerDtoToBeer(BeerDto beerDto);
}
