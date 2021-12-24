package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Payout;

public class PayoutModel {

	@JsonProperty("v1/payout")
	private Payout v1Payout;

	public PayoutModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PayoutModel(Payout v1Payout) {
		super();
		this.v1Payout = v1Payout;
	}

	public Payout getV1Payout() {
		return v1Payout;
	}

	public void setV1Payout(Payout v1Payout) {
		this.v1Payout = v1Payout;
	}
	
}
