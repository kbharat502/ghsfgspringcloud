package com.bharat.msscbrewery.web.controller.v2;

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

import com.bharat.msscbrewery.services.v2.BeerServiceV2;
import com.bharat.msscbrewery.web.model.v2.BeerDtoV2;

@Validated
@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {
	
	private final BeerServiceV2 beerService;

	public BeerControllerV2(BeerServiceV2 beerService) {
		this.beerService = beerService;
	}

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable("beerId") UUID beerId) {
		return new ResponseEntity<BeerDtoV2>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping  //POST - create new beer.
	public ResponseEntity<?> handlePost(@Valid @NotNull @RequestBody BeerDtoV2 beerDto) {
		BeerDtoV2 savedDto = beerService.saveNewBeer(beerDto);
		
		HttpHeaders headers = new HttpHeaders();
		//TODO: add hostname to URL.
		headers.add("Location", "/api/v2/beer/" + savedDto.getId());
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity<?> handlePut(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto) {
		beerService.updateBeer(beerId, beerDto);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("beerId") UUID beerId) {
		beerService.deleteBeer(beerId);
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
