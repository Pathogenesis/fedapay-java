package com.fedapay.collections;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Currency;

public class CurrencyCollection extends FedaPayCollection<Currency> {

	@JsonProperty("v1/currencies")
	private List<Currency> data;	
}
