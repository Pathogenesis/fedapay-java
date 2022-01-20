package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Account;

public class AccountModel extends FedaPayModel<Account>{
	
	@JsonProperty("v1/account")
	private Account data;
	
}