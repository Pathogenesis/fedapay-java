package com.fedapay.collections;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.model.Event;

public class EventCollection extends FedaPayCollection<Event> {

	@JsonProperty("v1/events")
	protected List<Event> data;
}
