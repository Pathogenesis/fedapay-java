package com.fedapay.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class FedaPayObject {

	@JsonIgnore
	public String rawJsonResponse;

	public FedaPayObject() {
	}

	public String getRawJsonResponse() {
		return rawJsonResponse;
	}

	public void setRawJsonResponse(String rawJsonResponse) {
		this.rawJsonResponse = rawJsonResponse;
	}
}
