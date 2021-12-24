package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Transaction;

public class TransactionModel extends FedaPayModel<Transaction>{
	
	@JsonProperty("v1/transaction")
	private Transaction data;
	
}
