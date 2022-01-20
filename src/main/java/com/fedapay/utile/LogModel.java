package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Log;

public class LogModel extends FedaPayModel<Log> {

	@JsonProperty("v1/log")
	private Log data;

}
