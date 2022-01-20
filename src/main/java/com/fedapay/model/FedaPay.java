package com.fedapay.model;

import javax.naming.directory.InvalidAttributeIdentifierException;

public class FedaPay {

	public static final String VERSION = "0.0.1";
	
	public static String environement;

	public static String apiKey;
	
	
	public static void setEnvironement(String environement) throws InvalidAttributeIdentifierException {
		if(environement != "live" && environement != "production" && environement != "dev" 
			&& environement != "development" && environement != "sandbox" && environement != "test" && environement != "localTest" && environement != "localTest-2" ) {
			throw new InvalidAttributeIdentifierException("Environment value not in 'live', 'production', 'dev', 'development','sandbox', 'test'.");
		}

		FedaPay.environement = environement;
	}
	
	public static void setApiKey(String apiKey) {
		FedaPay.apiKey = apiKey;
	}

}
