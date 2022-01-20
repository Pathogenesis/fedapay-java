package com.fedapay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.collections.EventCollection;
import com.fedapay.net.All;
import com.fedapay.net.Retrieve;
import com.fedapay.utile.EventModel;

public class Event extends FedaPayObject {

	private String id;
	private String type;
	private String entity;
	@JsonProperty("object_id")
	private String objectId;
	@JsonProperty("account_id")
	private String accountId;
	private String object;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("updated_at")
	private String updatedAt;

	public Event() {
		super();
	}

	public Event(String id, String type, String entity, String objectId, String accountId, String object,
			String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.type = type;
		this.entity = entity;
		this.objectId = objectId;
		this.accountId = accountId;
		this.object = object;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
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

	public static EventCollection all() throws Exception {
		return All.all(new EventCollection(), "/events");
	}

	public static Event retrieve(String eventId) throws Exception {
		Event event = Retrieve.retrieve(new EventModel(), "/events", eventId).getData();
		event.setRawJsonResponse(Retrieve.lastRequestResponse);
		return event;
	}
}
