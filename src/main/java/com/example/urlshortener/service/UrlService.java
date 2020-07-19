package com.example.urlshortener.service;

import com.example.urlshortener.entity.Url;

public interface UrlService {
	
	public Url findByHash(String hash);
	
	public Url store(Url url);
	
}
