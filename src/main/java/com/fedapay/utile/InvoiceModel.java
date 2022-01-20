package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Invoice;

public class InvoiceModel extends FedaPayModel<Invoice>{

	@JsonProperty("v1/invoice")
	private Invoice data;

}
