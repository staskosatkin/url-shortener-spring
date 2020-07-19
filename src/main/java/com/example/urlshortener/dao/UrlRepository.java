package com.example.urlshortener.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.urlshortener.entity.Url;

public interface UrlRepository extends JpaRepository<Url, String> {

}
