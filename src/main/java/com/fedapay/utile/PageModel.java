package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Page;

public class PageModel {

	@JsonProperty("v1/page")
	private Page v1Page;

	public PageModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageModel(Page v1Page) {
		super();
		this.v1Page = v1Page;
	}

	public Page getV1Page() {
		return v1Page;
	}

	public void setV1Page(Page v1Page) {
		this.v1Page = v1Page;
	}
	
}
