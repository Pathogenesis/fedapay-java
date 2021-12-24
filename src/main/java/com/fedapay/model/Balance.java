package com.fedapay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.collections.BalanceCollection;
import com.fedapay.net.All;
import com.fedapay.net.Retrieve;
import com.fedapay.net.Update;
import com.fedapay.utile.BalanceModel;

/**
 * Class Balance
 *
 * @property int $id
 * @property int $currency_id
 * @property int $account_id
 * @property int $amount
 * @property string $mode
 * @property string $deleted_at
 * @property string $created_at
 * @property string $updated_at
 *
 * @package com.fedapay.model
 */


public class Balance extends FedaPayObject {

	private String id;
	@JsonProperty("currency_id")
	private String currencyId;
	@JsonProperty("account_id")
	private String accountId;
	private String amount;
	private String  mode;
	@JsonProperty("deleted_at")
	private String  deleted_at;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("updated_at")
	private String updatedAt;
	
	public Balance() {
		super();
	}

	public Balance(String id, String currencyId, String accountId, String amount, String mode, String deleted_at,
			String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.currencyId = currencyId;
		this.accountId = accountId;
		this.amount = amount;
		this.mode = mode;
		this.deleted_at = deleted_at;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public static BalanceCollection all() throws Exception {
		return All.all(new BalanceCollection(), "/balances");
	}
	
	public static Balance retrieve(String balanceId) throws Exception {
		Balance balance = Retrieve.retrieve(new BalanceModel(), "/balances", balanceId).getV1Balance();
		balance.setRawJsonResponse(Update.lastRequestResponse);
		return balance;
	}
}
