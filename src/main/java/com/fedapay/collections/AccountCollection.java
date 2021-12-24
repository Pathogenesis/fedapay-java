package com.fedapay.collections;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Account;

public class AccountCollection extends FedaPayCollection<Account> {

	@JsonProperty("v1/accounts")
	private List<Account> data;

}
