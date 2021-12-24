package com.fedapay.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.collections.PayoutCollection;
import com.fedapay.net.All;
import com.fedapay.net.Create;
import com.fedapay.net.Delete;
import com.fedapay.net.Retrieve;
import com.fedapay.net.Update;
import com.fedapay.utile.PayoutModel;

/**
 * Class Payout
 *
 * @property int id
 * @property String reference
 * @property String amount
 * @property String status
 * @property int customer_id
 * @property int balance_id
 * @property String mode
 * @property int last_error_code
 * @property String last_error_message
 * @property String created_at
 * @property String updated_at
 * @property String scheduled_at
 * @property String sent_at
 * @property String failed_at
 * @property String deleted_at
 *
 * @package com.fedapay.model
 */

public class Payout extends FedaPayObject {

	private String id;
	private String reference;
	private String amount;
	private String status;
	@JsonProperty("customer_id")
	private String customerId;
	@JsonProperty("balance_id")
	private String balanceId;
	private String mode;
	@JsonProperty("last_error_code")
	private String lastErrorCode;
	@JsonProperty("last_error_message")
	private String lastErrorMessage;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("updatedAt")
	private String updated_at;
	@JsonProperty("scheduledAt")
	private String scheduled_at;
	@JsonProperty("sent_at")
	private String sentAt;
	@JsonProperty("failed_at")
	private String failedAt;
	@JsonProperty("deleted_at")
	private String deletedAt;

	public Payout() {
		super();
	}

	public Payout(String id, String reference, String amount, String status, String customerId, String balanceId,
			String mode, String lastErrorCode, String lastErrorMessage, String createdAt, String updated_at,
			String scheduled_at, String sentAt, String failedAt, String deletedAt) {
		super();
		this.id = id;
		this.reference = reference;
		this.amount = amount;
		this.status = status;
		this.customerId = customerId;
		this.balanceId = balanceId;
		this.mode = mode;
		this.lastErrorCode = lastErrorCode;
		this.lastErrorMessage = lastErrorMessage;
		this.createdAt = createdAt;
		this.updated_at = updated_at;
		this.scheduled_at = scheduled_at;
		this.sentAt = sentAt;
		this.failedAt = failedAt;
		this.deletedAt = deletedAt;
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

	public String getBalanceId() {
		return balanceId;
	}

	public void setBalanceId(String balanceId) {
		this.balanceId = balanceId;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getLastErrorCode() {
		return lastErrorCode;
	}

	public void setLastErrorCode(String lastErrorCode) {
		this.lastErrorCode = lastErrorCode;
	}

	public String getLastErrorMessage() {
		return lastErrorMessage;
	}

	public void setLastErrorMessage(String lastErrorMessage) {
		this.lastErrorMessage = lastErrorMessage;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getScheduled_at() {
		return scheduled_at;
	}

	public void setScheduled_at(String scheduled_at) {
		this.scheduled_at = scheduled_at;
	}

	public String getSentAt() {
		return sentAt;
	}

	public void setSentAt(String sentAt) {
		this.sentAt = sentAt;
	}

	public String getFailedAt() {
		return failedAt;
	}

	public void setFailedAt(String failedAt) {
		this.failedAt = failedAt;
	}

	public String getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	public static PayoutCollection all() throws Exception {
		return All.all(new PayoutCollection(), "/payouts");
	}
	
	public static Payout retrieve(String payoutId) throws Exception {
		Payout payout = Retrieve.retrieve(new PayoutModel(), "/payouts", payoutId).getV1Payout();
		payout.setRawJsonResponse(Retrieve.lastRequestResponse);
		return payout;
	}
	
	public static Payout create(Map<String, Object> payoutMap) throws Exception {
		Payout payout = Create.create(new PayoutModel(), "/payouts", payoutMap).getV1Payout();
		payout.setRawJsonResponse(Create.lastRequestResponse);
		return payout;
	}
	
	public static Payout update(String payoutId, Map<String, Object> payoutMap) throws Exception {
		Payout payout = Update.update(new PayoutModel(), "/payouts", payoutId, payoutMap).getV1Payout();
		payout.setRawJsonResponse(Update.lastRequestResponse);
		return payout;
	}
	
	public Payout save() throws Exception {
		Payout payout = Update.update(new PayoutModel(), "/payouts", this.id, this.toMap()).getV1Payout();
		payout.setRawJsonResponse(Update.lastRequestResponse);
		return payout;
	}

	public static String delete(String payoutId) throws Exception {
		Delete.delete("/payouts", payoutId);
		return "Payout deleted";
	}
	
	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (this.id != null) {			
			map.put("id", this.id);
			map.put("reference", this.reference);
			map.put("amount", this.amount);
			map.put("status", this.status);
			map.put("customer_id", this.customerId);
			map.put("balance_id", this.balanceId);
			map.put("mode", this.mode);
			map.put("last_error_code", this.lastErrorCode);
			map.put("last_error_message", this.lastErrorMessage);
		}
		return map;
	}
}
