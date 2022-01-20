package com.fedapay.collections;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Invoice;

public class InvoiceCollection extends FedaPayCollection<Invoice> {

	@JsonProperty("v1/invoices")
	private List<Invoice> data;
}
