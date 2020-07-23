package com.example.urlshortener.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.urlshortener.client.KGSClient;
import com.example.urlshortener.dao.UrlRepository;
import com.example.urlshortener.entity.Url;

@Service
public class UrlServiceImpl implements UrlService {

	@Autowired
	private UrlRepository urlRepository;
	
	@Autowired
	private KGSClient client;
	
	@Override
	public Url store(Url url) {
		
		url.setHash(client.fetch());
		url.setUserId(0);
		urlRepository.save(url);
		
		return url;
	}

	@Override
	public Url findByHash(String hash) {

		Optional<Url> result = urlRepository.findById(hash);
		if (result.isPresent()) {
			return result.get();
		}
		
		return null;
	}

}
