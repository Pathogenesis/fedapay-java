package com.fedapay.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.collections.TransactionCollection;
import com.fedapay.net.All;
import com.fedapay.net.Create;
import com.fedapay.net.Delete;
import com.fedapay.net.Requestor;
import com.fedapay.net.Retrieve;
import com.fedapay.net.Update;
import com.fedapay.utile.Serializer;
import com.fedapay.utile.TransactionModel;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction extends FedaPayObject {

	// Correction de l"annotation
	private String id;

	@JsonProperty("reference")
	private String reference;

	@JsonProperty("description")
	private String description;

	@JsonProperty("callback_url")
	private String callbackUrl;

	@JsonProperty("amount")
	private String amount;

	@JsonProperty("status")
	private String status;

	@JsonProperty("customer_id")
	private String customerId;

	@JsonProperty("currency_id")
	private String currencyId;

	@JsonProperty("customer")
	private Customer customer;

	@JsonProperty("phone_number")
	private PhoneNumber phoneNumber;

	private Map<String, Object> metadata;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("updated_at")
	private String updatedAt;
	
	public static String[] PAID_STATUS = {"approved", "transferred", "refunded", "approved_partially_refunded", "transferred_partially_refunded"};
    private static String[] AVAILABLE_MOBILE_MONEY = {"mtn", "moov", "mtn_ci", "moov_tg", "mtn_open"};

	public Transaction(String id, String reference, String description, String callbackUrl, String amount,
			String status, String customerId, String currencyId, Customer customer, PhoneNumber phoneNumber,
			Map<String, Object> metadata, String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.reference = reference;
		this.description = description;
		this.callbackUrl = callbackUrl;
		this.amount = amount;
		this.status = status;
		this.customerId = customerId;
		this.currencyId = currencyId;
		this.customer = customer;
		this.phoneNumber = phoneNumber;
		this.metadata = metadata;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Transaction() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callback_url) {
		this.callbackUrl = callback_url;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public Object getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, Object> metadata) {
		this.metadata = metadata;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@JsonIgnore
	public String getCreatedAt() {
		return createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static TransactionCollection all() throws Exception {
		return All.all(new TransactionCollection(), "/transactions");
	}

	public static Transaction create(Map<String, Object> transactionDataMap) throws Exception {
		Transaction transaction = Create.create(new TransactionModel(), "/transactions", transactionDataMap).getData();
		transaction.setRawJsonResponse(Create.lastRequestResponse) ;
		return transaction;
	}

	public static Transaction retrieve(String transactionId) throws Exception {
		Transaction transaction = Retrieve.retrieve(new TransactionModel(), "/transactions", transactionId)
				.getData();
		transaction.setRawJsonResponse(Retrieve.lastRequestResponse) ;
		return transaction;
	}

	public static Transaction update(String transactionId, Map<String, Object> transactionDataMap) throws Exception {
		Transaction transaction = Update.update(new TransactionModel(), "/transactions", transactionId, transactionDataMap).getData();
		transaction.setRawJsonResponse(Update.lastRequestResponse) ;
		return transaction;
	}

	public Transaction save() throws Exception {
		Transaction transaction = Update.update(new TransactionModel(), "/transactions", this.id, this.toMap()).getData();
		transaction.setRawJsonResponse(Update.lastRequestResponse) ;
		return transaction;
	}

	public static String delete(String transactionId) throws Exception {
		Delete.delete("/transactions", transactionId);
		return "Transaction deleted";
	}
	
	protected Boolean mobileMoneyModeAvailable(String mode) {
		return Arrays.stream(AVAILABLE_MOBILE_MONEY).anyMatch(mode::equals);
	}
	
	public Boolean wasPaid() {
		return Arrays.stream(PAID_STATUS).anyMatch(this.status::equals);
	}
	
	public Boolean wasRefunded() {
		return this.status.equals("refunded");
	}
	
	public Boolean wasPartiallyRefunded() {
		return this.status.equals("partially_refunded");
	}
	
	public TransactionToken generateToken() throws Exception {
		if (this.id != null) {
			System.out.println(Requestor.postRequest( "/transactions/" + this.id +"/token", null));
			return Serializer.allSerializer(new TransactionToken(), Requestor.postRequest("/transactions/" + this.id +"/token", null));
		}else {
			throw new java.lang.Exception("id can't be null");
		}
	}
	
	public String getReceipUrl() throws Exception {
		if (this.id != null) {
			return Serializer.allSerializer(new HashMap<String, String>(), Requestor.postRequest("/transactions/" + this.id +"/receipt_url", null)).get("url");
		} else {
			throw new java.lang.Exception("id can't be null");
		}
	}
	
	public  void name() {
		
	}

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (this.id != null) {
			map.put("id", this.id);
			map.put("reference", this.reference);
			map.put("description", this.description);
			map.put("callback_url", this.callbackUrl);
			map.put("amount", this.amount);
			map.put("customer_id", this.customerId);
			map.put("currency_id", this.currencyId);
			map.put("customer", this.customer);
			map.put("phone_number", this.phoneNumber);
			map.put("metadata", this.metadata);
		}

		return map;
	}

}
