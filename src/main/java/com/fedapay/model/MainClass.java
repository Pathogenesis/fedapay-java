package com.fedapay.model;

import java.util.HashMap;
import java.util.Map;

import javax.naming.directory.InvalidAttributeIdentifierException;

import com.fedapay.collections.TransactionCollection;

public class MainClass {

	public static void main(String[] args) {
		
		FedaPay.setApiKey("sk_sandbox_lWw2kwhv4apq-5N-QiTGMpy9");

		try {
			
			FedaPay.setEnvironement("sandbox");
			
		} catch (InvalidAttributeIdentifierException e) {
			e.printStackTrace();
		}
		
//		Map<String, Object> customerMap = new HashMap<String, Object>();
//		
//		customerMap.put("firstname", "rea");
//		customerMap.put("lastname", "mood");
//		customerMap.put("email", "reamood@gmail.com");
//		
		try {
//			Customer.create(customerMap);
			Payout.all();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
