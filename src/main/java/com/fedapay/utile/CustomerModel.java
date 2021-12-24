package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Customer;
import com.fedapay.model.FedaPayObject;

public class CustomerModel extends FedaPayObject {


	@JsonProperty("v1/customer")
	private Customer v1Customer;

	public CustomerModel() {
		super();
	}

	public CustomerModel(Customer v1Customer) {
		super();
		this.v1Customer = v1Customer;
	}

	public Customer getV1Customer() {
		return v1Customer;
	}

	public void setV1Customer(Customer v1Customer) {
		this.v1Customer = v1Customer;
	}

}
