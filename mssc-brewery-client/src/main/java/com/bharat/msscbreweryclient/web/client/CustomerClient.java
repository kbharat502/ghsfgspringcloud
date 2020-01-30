package com.bharat.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bharat.msscbreweryclient.web.model.CustomerDto;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class CustomerClient {

 public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
	
	private String apiHost;
	
	private final RestTemplate restTemplate;
	
	public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}
	
	public CustomerDto getCustomerById(UUID uuid) {
		return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + uuid.toString(), CustomerDto.class);
	}
	
	
	public URI saveNewCustomer(CustomerDto dto) {
		return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, dto);
	}
	
	public void updateCustomer(UUID uuid, CustomerDto customerDto) {
		restTemplate.put(apiHost + CUSTOMER_PATH_V1 + uuid.toString(), customerDto);
	}
	
	public void deleteCustomer(UUID uuid) {
		restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + uuid.toString());
	}
}
