package com.example.urlshortener.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "urls")
public class Url {
	
	@Id
	private String hash;
	
	@Column(name = "original_url")
	@JsonProperty("original_url")
	private String originalUrl;
	
	@Column(name = "expiration_date")
	@JsonProperty("expiration_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Date expirationDate;
	
	@Column(name = "custom_alias")
	@JsonProperty("custom_alias")
	private String customAlias;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "created_at")
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private Date createdAt;
	
	public Url () {
		
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCustomAlias() {
		return customAlias;
	}

	public void setCustomAlias(String customAlias) {
		this.customAlias = customAlias;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Url [hash=" + hash + ", originalUrl=" + originalUrl + ", expirationDate=" + expirationDate
				+ ", customAlias=" + customAlias + ", userId=" + userId + ", createdAt=" + createdAt + "]";
	}
	
}
