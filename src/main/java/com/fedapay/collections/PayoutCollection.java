package com.fedapay.collections;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Payout;

public class PayoutCollection extends FedaPayCollection<Payout> {

	@JsonProperty("v1/payouts")
	private List<Payout> data;
}
