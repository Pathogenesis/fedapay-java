package com.fedapay.collections;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Customer;

public class CustomerCollection extends FedaPayCollection<Customer>{


	@JsonProperty("v1/customers")
	private List<Customer> data;
}
