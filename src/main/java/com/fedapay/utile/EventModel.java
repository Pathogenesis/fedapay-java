package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Event;

public class EventModel {

	@JsonProperty("v1/event")
	private Event v1Event;

	public Event getV1Event() {
		return v1Event;
	}

	public void setV1Event(Event v1Event) {
		this.v1Event = v1Event;
	}
	
}
