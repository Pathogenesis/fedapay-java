package com.fedapay.utile;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapToJson {
		
	public MapToJson() {
		
	}
	
	public static String mapToArray (Map<String, Object> bodyData ) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {

			objectMapper.setSerializationInclusion(Include.NON_NULL);
			String json = objectMapper.writeValueAsString(bodyData);
			return json;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
