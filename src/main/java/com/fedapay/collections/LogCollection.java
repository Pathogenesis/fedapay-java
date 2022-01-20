package com.fedapay.collections;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Log;

public class LogCollection extends FedaPayCollection<Log> {

	@JsonProperty("v1/logs")
	private List<Log> data;
}
