package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Page;

public class PageModel extends FedaPayModel<Page>{

	@JsonProperty("v1/page")
	private Page data;

}
