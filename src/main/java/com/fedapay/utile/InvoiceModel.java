package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Invoice;

public class InvoiceModel {

	@JsonProperty("v1/invoice")
	private Invoice v1Invoice;

	public Invoice getV1Invoice() {
		return v1Invoice;
	}

	public void setV1Invoice(Invoice v1Invoice) {
		this.v1Invoice = v1Invoice;
	}
	
}
