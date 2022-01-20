package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Customer;

public class CustomerModel extends FedaPayModel<Customer> {


	@JsonProperty("v1/customer")
	private Customer data;

}
