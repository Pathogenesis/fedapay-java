package com.fedapay.net;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fedapay.exception.ApiError;
import com.fedapay.model.FedaPay;
import com.fedapay.utile.Serializer;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Retrieve {
	
	public static String lastRequestResponse;
	
	public static <T> T retrieve( T cls, String serviceUrl, String id) throws Exception {

		Request request = new Request.Builder().url(UrlMaker.getUrl(serviceUrl) + "/" + id)
				.addHeader("Authorization", "Bearer " + FedaPay.apiKey)
				.addHeader("Content-Type", "application/json")
				.addHeader("Accept", "application/json")
				.get().build();

		OkHttpClient client = new OkHttpClient();

		Response response = client.newCall(request).execute();
		String responseString = response.body().string();
		if (response.isSuccessful()) {
			lastRequestResponse = responseString;
			return (T) Serializer.allSerializer(cls, responseString);
		} else {
			if (responseString.contains("message")) {

				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				
				ApiError error = mapper.readValue(responseString, ApiError.class);
				throw new java.lang.Exception("An error occured : " + error.getMessage());
			} else {
				throw new java.lang.Exception("An error occured : " + responseString);
			}
		}

	}

}
