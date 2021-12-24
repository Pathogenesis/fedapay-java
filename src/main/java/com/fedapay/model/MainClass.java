package com.fedapay.model;

import java.util.List;

import com.fedapay.collections.EventCollection;
import com.fedapay.collections.TransactionCollection;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		FedaPay.setEnvironement("sandbox");
		FedaPay.setApiKey("sk_sandbox_lWw2kwhv4apq-5N-QiTGMpy9");
		
		System.out.println(Transaction.retrieve("35340").wasPaid());
		
		EventCollection events = Event.all();
		for(int i = 0; i < events.getData().size(); i++) {
			Event event = events.getData().get(i);
			event.getAccountId();
		}
		
		System.out.println(events.getMeta().get("current_page")); 
		System.out.println(events.getData().get(0).getAccountId());
		
		TransactionCollection transactionCollection = Transaction.all();
		
		List<Transaction> transactionList = transactionCollection.getData();
		System.out.println(transactionList.get(0).getId());
		
		String json = transactionCollection.getMeta().get("per_page").toString();
		System.out.println(json);
		
		//Generate Token Transaction
		
		Transaction transaction = Transaction.retrieve("35929");
		System.out.println(transaction.rawJsonResponse);
		
		//Get transaction receipt url 
		
		transaction = transactionList.get(19);
		String s = transaction.getReceipUrl();
		System.out.println(s);
		 
	}
}
