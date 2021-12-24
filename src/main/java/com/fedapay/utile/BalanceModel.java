package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Balance;

public class BalanceModel {

	@JsonProperty("v1/balance")
	private Balance v1Balance;

	public BalanceModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BalanceModel(Balance v1Balance) {
		super();
		this.v1Balance = v1Balance;
	}

	public Balance getV1Balance() {
		return v1Balance;
	}

	public void setV1Balance(Balance v1Balance) {
		this.v1Balance = v1Balance;
	}
	
}
