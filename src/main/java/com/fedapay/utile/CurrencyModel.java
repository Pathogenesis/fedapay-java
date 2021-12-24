package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Currency;

public class CurrencyModel {

	@JsonProperty("v1/currency")
	private Currency v1Currency ;

	public CurrencyModel() {
		super();
	}

	public CurrencyModel(Currency v1Currency) {
		super();
		this.v1Currency = v1Currency;
	}

	public Currency getV1Currency() {
		return v1Currency;
	}

	public void setV1Currency(Currency v1Currency) {
		this.v1Currency = v1Currency;
	}
	
}
