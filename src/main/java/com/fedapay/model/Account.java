package com.fedapay.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.collections.AccountCollection;
import com.fedapay.net.All;
import com.fedapay.net.Create;
import com.fedapay.net.Delete;
import com.fedapay.net.Update;
import com.fedapay.utile.AccountModel;


public class Account extends FedaPayObject {

	private String id;
	private String name;
	private String timezone;
	private String country;
	private String verify;
	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("created_at")
	private String updatedAt;

	public Account() {
	}

	public Account(String id, String name, String timezone, String country, String verify, String createdAt,
			String updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.timezone = timezone;
		this.country = country;
		this.verify = verify;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String created_at) {
		this.createdAt = created_at;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updated_at) {
		this.updatedAt = updated_at;
	}

	public static AccountCollection all() throws Exception {
		return All.all(new AccountCollection(), "/accounts");
	}

	public static Account create(Map<String, Object> accountMap) throws Exception {
		Account account = Create.create(new AccountModel(), "/accounts", accountMap).getV1Account();
		account.setRawJsonResponse(Create.lastRequestResponse);
		return account;
	}

	public static Account update(String accountId, Map<String, Object> accountMap) throws Exception {
		Account account = Update.update(new AccountModel(), "/accounts", accountId, accountMap).getV1Account();
		account.setRawJsonResponse(Update.lastRequestResponse);
		return account;
	}

	public Account save() throws Exception {
		Account account = Update.update(new AccountModel(), "/accounts", this.id, this.toMap()).getV1Account();
		account.setRawJsonResponse(Update.lastRequestResponse);
		return account;
	}

	public static String delete(String accountId) throws Exception {
		Delete.delete("/accounts", accountId);
		return "Account deleted";
	}

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();

		if (this.id != null) {
			map.put("id", this.id);
			map.put("name", this.name);
			map.put("timezone", this.timezone);
			map.put("country", this.country);
			map.put("verify", this.verify);
		}
		return map;
	}
}
