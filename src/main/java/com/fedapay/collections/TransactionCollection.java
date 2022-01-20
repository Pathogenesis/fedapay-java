package com.fedapay.collections;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Transaction;

public class TransactionCollection extends FedaPayCollection<Transaction> {

	@JsonProperty("v1/transactions")
	private List<Transaction> data;
}
