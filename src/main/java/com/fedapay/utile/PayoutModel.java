package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Payout;

public class PayoutModel extends FedaPayModel<Payout>{

	@JsonProperty("v1/payout")
	private Payout data;

}
