package com.fedapay.net;

import java.util.Objects;
import java.util.ResourceBundle;

import com.fedapay.model.FedaPay;

public class UrlMaker {
	
	
	public static String getUrl(String serviceUrl) {
		FedaPay.environement = Objects.requireNonNull(FedaPay.environement, "FedaPay environement can't be null");
		FedaPay.apiKey = Objects.requireNonNull(FedaPay.apiKey, "FedaPay apiKey can't be null");
		
		ResourceBundle resource = ResourceBundle.getBundle("fedapay.config");
		
		return resource.getString(FedaPay.environement) + "/v1" +serviceUrl; 
	}
}
