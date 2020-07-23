package com.example.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.urlshortener.entity.Url;
import com.example.urlshortener.service.UrlService;

@Controller
public class PublicController {
	
	@Autowired
	private UrlService urlService;
	
	@GetMapping("/{hash}")
	public ResponseEntity<Object> find(@PathVariable String hash) {
		
		Url url = urlService.findByHash(hash);
		
		if (url == null) {
			return ResponseEntity.notFound().build();
		}

		HttpHeaders headers = new HttpHeaders();

		headers.add("Location", url.getOriginalUrl());

		return new ResponseEntity<Object>(headers, HttpStatus.FOUND);
	}
}
