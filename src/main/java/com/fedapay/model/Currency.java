package com.fedapay.model;

import com.fedapay.collections.CurrencyCollection;
import com.fedapay.net.All;
import com.fedapay.net.Retrieve;
import com.fedapay.utile.CurrencyModel;

public class Currency extends FedaPayObject {
	
	private String id;
	private String name;
	private String iso;
	private String code;
	private String prefix;
	private String suffix;
	private String div;
	
	public Currency(String id, String name, String iso, String code, String prefix, String suffix, String div) {
		super();
		this.id = id;
		this.name = name;
		this.iso = iso;
		this.code = code;
		this.prefix = prefix;
		this.suffix = suffix;
		this.div = div;
	}

	public Currency() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}
	
	public static CurrencyCollection all() throws Exception {
		return All.all(new CurrencyCollection(), "/currencies");
	}
	
	public static Currency retrieve(String currencyId) throws Exception {
		Currency currency =  Retrieve.retrieve(new CurrencyModel(), "/currencies", currencyId).getData();
		currency.setRawJsonResponse(Retrieve.lastRequestResponse);
		return currency;
	}
	
}
