package com.fedapay.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class TransactionToken {

	@JsonProperty("token")
	public String token;
	
	@JsonProperty("url")
	public String securePaymentLink;

	public TransactionToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSecurePaymentLink() {
		return securePaymentLink;
	}

	public void setSecurePaymentLink(String securePaymentLink) {
		this.securePaymentLink = securePaymentLink;
	}

	
}
