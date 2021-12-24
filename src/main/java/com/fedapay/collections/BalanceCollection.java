package com.fedapay.collections;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Balance;

public class BalanceCollection extends FedaPayCollection<Balance> {

	@JsonProperty("v1/balances")
	private List<Balance> data;

}
