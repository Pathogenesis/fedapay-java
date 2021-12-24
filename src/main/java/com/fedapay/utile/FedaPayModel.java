package com.fedapay.utile;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FedaPayModel<T> {

	@JsonProperty
	protected T data;
	
	@JsonProperty
	protected Map<String, Object> meta;

	public FedaPayModel() {
		super();
	}

	public FedaPayModel(T data, Map<String, Object> meta) {
		super();
		this.data = data;
		this.meta = meta;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Map<String, Object> getMeta() {
		return meta;
	}

	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}
}
