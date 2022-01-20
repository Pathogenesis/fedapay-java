package com.fedapay.collections;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Page;

public class PageCollection extends FedaPayCollection<Page> {

	@JsonProperty("v1/pages")
	private List<Page> data;
}
