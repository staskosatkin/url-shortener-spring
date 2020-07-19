package com.example.urlshortener.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KGSClient {
	
	@Value("${kgs.host}")
	private String host;
	
	public String fetch() {
		
		RestTemplate rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "*/*");
		
		String uri = host + "/api/fetch";
		
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<String> response = rest.exchange(uri, HttpMethod.POST, request, String.class);
		
		return response.getBody();
	}
}
