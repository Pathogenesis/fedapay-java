package com.fedapay.utile;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serializer<T> {
	
	public Serializer() {
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T allSerializer(T cls, String dataJson) throws Exception {
		System.out.println(dataJson);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		return (T) mapper.readValue(dataJson, cls.getClass());
	}
	

}
