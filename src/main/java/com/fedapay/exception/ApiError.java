package com.fedapay.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiError {

	@JsonProperty("message")
	private String message;
		
	public ApiError(String message) {
		this.message = message;
	}

	public ApiError() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
