package com.fedapay.collections;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FedaPayCollection<T> {

	@JsonProperty
	protected List<T> data;
	
	@JsonProperty
	protected Map<String, Object> fedaPayObject;
	
	@JsonProperty
	protected Map<String, Object> meta;


	public FedaPayCollection() {
		super();
	}

	public FedaPayCollection(List<T> data, Map<String, Object> fedaPayObject, Map<String, Object> meta) {
		super();
		this.data = data;
		this.fedaPayObject = fedaPayObject;
		this.meta = meta;
	}



	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Map<String, Object> getMeta() {
		return meta;
	}

	public void setMeta(Map<String, Object> meta) {
		this.meta = meta;
	}

	public Map<String, Object> getFedaPayObject() {
		return fedaPayObject;
	}

	public void setFedaPayObject(Map<String, Object> fedaPayObject) {
		this.fedaPayObject = fedaPayObject;
	}
}
