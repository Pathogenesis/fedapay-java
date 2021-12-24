package com.fedapay.model;

import javax.naming.directory.InvalidAttributeIdentifierException;

/**
 * Class FedaPay
 *
 * @package com.fedapay.model
 */

public class FedaPay {

	public static final String VERSION = "0.0.1";
	
    // @String The environment for the FedaPay API.
	public static String environement;

	// @String The FedaPay API key to be used for requests.
	public static String apiKey;
	
	/**
     * @param string environment The API environment.
     * @return void
     */
	public static void setEnvironement(String environement) throws InvalidAttributeIdentifierException {
		if(environement != "live" && environement != "production" && environement != "dev" 
			&& environement != "development" && environement != "sandbox" && environement != "test") {
			throw new InvalidAttributeIdentifierException("Environment value not in 'live', 'production', 'dev', 'development','sandbox', 'test'.");
		}

		FedaPay.environement = environement;
	}
	
	/**
     * Sets the API key to be used for requests.
     *
     * @param string $apiKey
     * @return void
     */
	public static void setApiKey(String apiKey) {
		FedaPay.apiKey = apiKey;
	}

}
