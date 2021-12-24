package com.fedapay.exception;

public class SignatureVerificationException extends Exception {

	private static final long serialVersionUID = 2L;

	private final String sigHeader;

	public SignatureVerificationException(String message, String sigHeader) {
		super();
		this.sigHeader = sigHeader;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSigHeader() {
		return sigHeader;
	}

}
