package com.fedapay.utile;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FedaPayModel<T> {

	@JsonProperty
	protected T data;
	

	public FedaPayModel() {
		super();
	}

	public FedaPayModel(T data, Map<String, Object> meta) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
