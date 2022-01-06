package com.fedapay.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.collections.PageCollection;
import com.fedapay.net.All;
import com.fedapay.net.Create;
import com.fedapay.net.Delete;
import com.fedapay.net.Retrieve;
import com.fedapay.net.Update;
import com.fedapay.utile.PageModel;


public class Page extends FedaPayObject {

	private String id;
	private String name;
	private String description;
	private String reference;
	private String published;
	private String amount;
	@JsonProperty("enable_phone_number")
	private String enablePhoneNumber;
	@JsonProperty("callback_url")
	private String callbackUrl;
	@JsonProperty("custom_fields")
	private List<Object> customFields;
	@JsonProperty("image_url")
	private String imageUrl;
	@JsonProperty("account_id")
	private String accountId;
	@JsonProperty("currency_id")
	private String currencyId;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonProperty("deleted_at")
	private String deletedAt;

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Page(String id, String name, String description, String reference, String published, String amount,
			String enablePhoneNumber, String callbackUrl, List<Object> customFields, String imageUrl, String accountId,
			String currencyId, String createdAt, String updatedAt, String deletedAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.reference = reference;
		this.published = published;
		this.amount = amount;
		this.enablePhoneNumber = enablePhoneNumber;
		this.callbackUrl = callbackUrl;
		this.customFields = customFields;
		this.imageUrl = imageUrl;
		this.accountId = accountId;
		this.currencyId = currencyId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getEnablePhoneNumber() {
		return enablePhoneNumber;
	}

	public void setEnablePhoneNumber(String enablePhoneNumber) {
		this.enablePhoneNumber = enablePhoneNumber;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public List<Object> getCustomFields() {
		return customFields;
	}

	public void setCustomFields(List<Object> customFields) {
		this.customFields = customFields;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
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

	public String getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}

	public static PageCollection all() throws Exception {
		return All.all(new PageCollection(), "/pages");
	}

	public static Page retrieve(String pageId) throws Exception {
		Page page = Retrieve.retrieve(new PageModel(), "/pages", pageId).getV1Page();
		page.setRawJsonResponse(Retrieve.lastRequestResponse);
		return page;
	}

	public static Page create(Map<String, Object> pageMap) throws Exception {
		Page page = Create.create(new PageModel(), "/pages", pageMap).getV1Page();
		page.setRawJsonResponse(Create.lastRequestResponse);
		return page;
	}

	public static Page update(String pageId, Map<String, Object> pageMap) throws Exception {
		Page page = Update.update(new PageModel(), "/pages", pageId, pageMap).getV1Page();
		page.setRawJsonResponse(Update.lastRequestResponse);
		return page;
	}
	
	public Page save() throws Exception {
		Page page = Update.update(new PageModel(), "/pages", this.id, this.toMap()).getV1Page();
		page.setRawJsonResponse(Update.lastRequestResponse);
		return page;
	}

	public static String delete(String pageId) throws Exception {
		Delete.delete("/pages", pageId);
		return "Page deleted";
	}

	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();

		if (this.id != null) {
		
			map.put("id", this.id);
			map.put("name", this.name);
			map.put("description", this.description);
			map.put("reference", this.reference);
			map.put("published", this.published);
			map.put("amount", this.amount);
			map.put("enable_phone_number", this.enablePhoneNumber);
			map.put("callback_url", this.callbackUrl);
			map.put("custom_fields", this.customFields);
			map.put("image_url", this.imageUrl);
			map.put("account_id", this.accountId);
			map.put("currency_id", this.currencyId);
		}
		return map;
	}
}
