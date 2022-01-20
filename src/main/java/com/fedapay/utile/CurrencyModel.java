package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Currency;

public class CurrencyModel extends FedaPayModel<Currency> {

	@JsonProperty("v1/currency")
	private Currency data ;
}
