package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Log;

public class LogModel {

	@JsonProperty("v1/log")
	private Log v1Log;

	public LogModel() {
		super();
	}

	public LogModel(Log v1Log) {
		super();
		this.v1Log = v1Log;
	}

	public Log getV1Log() {
		return v1Log;
	}

	public void setV1Log(Log v1Log) {
		this.v1Log = v1Log;
	}
	
}
