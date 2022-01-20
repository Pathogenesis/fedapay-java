package com.fedapay.utile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Event;

public class EventModel extends FedaPayModel<Event>{

	@JsonProperty("v1/event")
	private Event data;

}
