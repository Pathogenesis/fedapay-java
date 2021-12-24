package com.fedapay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Webhook {

	 private String id;
	 @JsonProperty("public_key")
	 private String publicKey;
	 @JsonProperty("private_key")
	 private String privateKey;
	 @JsonProperty("created_at")
	 private String createdAt;
	 @JsonProperty("updatedAt")
	 private String updated_at;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public String getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	 
	 
}
