package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Account;
import com.fedapay.model.FedaPayObject;

public class AccountModel extends FedaPayObject {

	@JsonProperty("v1/account")
	private Account v1Account;

	public AccountModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountModel(Account v1Account) {
		super();
		this.v1Account = v1Account;
	}

	public Account getV1Account() {
		return v1Account;
	}

	public void setV1Account(Account v1Account) {
		this.v1Account = v1Account;
	}
	
	
}
