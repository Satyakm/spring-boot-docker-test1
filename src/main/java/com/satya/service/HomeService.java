package com.satya.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HomeService {
	
	@Autowired
    private RestTemplate restTemplate;

	public Map<String, String> getHomeValue() {
		
		ResponseEntity<Map<String, String>> quoteResponse = restTemplate
				.exchange("http://DEMO-DOCKER-DB/rest/db/", HttpMethod.GET,
                null, new ParameterizedTypeReference<Map<String, String>>() {
                });
		
		return quoteResponse.getBody();
	}
	
}
