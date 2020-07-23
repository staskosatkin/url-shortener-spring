package com.example.urlshortener.rest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.urlshortener.entity.Url;
import com.example.urlshortener.service.UrlService;

@RestController
@RequestMapping("/api")
public class UrlController {

	@Autowired
	private UrlService urlService;
	
	@GetMapping("/status")
	public String status() {
		return "OK";
	}
	
	@PostMapping("/urls")
	public ResponseEntity<Object> create(@RequestBody Url url)
	{
		urlService.store(url);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentServletMapping()
				.path("/{hash}")
				.buildAndExpand(url.getHash()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
