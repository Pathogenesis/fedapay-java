package com.fedapay.utile;

import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToFedaPayObject {
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> jsonToFedapayObject(String jsonData) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(jsonData, Map.class);
	}

}
