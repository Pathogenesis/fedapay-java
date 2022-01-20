package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Balance;

public class BalanceModel extends FedaPayModel<Balance> {
	
	@JsonProperty("v1/balance")
	private Balance data;
	
}