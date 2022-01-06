package com.fedapay.model;

import java.util.HashMap;
import java.util.Map;

import javax.naming.directory.InvalidAttributeIdentifierException;

public class MainClass {

	public static void main(String[] args) {
		
		try {
			
			FedaPay.setEnvironement("sandbox");
			
		} catch (InvalidAttributeIdentifierException e) {
			e.printStackTrace();
		}
		
		FedaPay.setApiKey("sk_sandbox_lWw2kwhv4apq-5N-QiTGMpy9");
		
		Map<String, Object> customerMap = new HashMap<String, Object>();
		
		customerMap.put("firstname", "John");
		customerMap.put("lastname", "Doe");
		customerMap.put("email", "johndoe@gmail.com");
		
		try {
			
			Customer customer = Customer.create(customerMap);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
