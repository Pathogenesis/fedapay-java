package com.fedapay.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fedapay.collections.LogCollection;
import com.fedapay.model.Log;

public class LogTest {

	WireMockManager wireMockManager;

	private final String logId = "AX5s342Qrpn4KQl9jtGL";

	@Before
	public void initializeWireMockManager() throws Exception {
		wireMockManager = new WireMockManager();
	}

	@Test
	public void shouldReturnCurrencyCollection() throws Exception {
		wireMockManager.startTestServer("/logs", "get","{\n" + 
				"    \"v1/log\": [\n" + 
				"        {\n" + 
				"            \"klass\": \"v1/log\",\n" + 
				"            \"id\": \"AX5s342Qrpn4KQl9jtGL\",\n" + 
				"            \"method\": \"POST\",\n" + 
				"            \"url\": \"/v1/customers\",\n" + 
				"            \"status\": 200,\n" + 
				"            \"ip_address\": \"41.85.177.164\",\n" + 
				"            \"version\": \"Unknown\",\n" + 
				"            \"source\": \"Unknown\",\n" + 
				"            \"query\": \"{}\",\n" + 
				"            \"body\": \"{\\\"firstname\\\":\\\"rea\\\",\\\"email\\\":\\\"reamood@gmail.com\\\",\\\"lastname\\\":\\\"mood\\\",\\\"customer\\\":{\\\"firstname\\\":\\\"rea\\\",\\\"lastname\\\":\\\"mood\\\",\\\"email\\\":\\\"reamood@gmail.com\\\"}}\",\n" + 
				"            \"response\": \"{\\\"id\\\":5681,\\\"firstname\\\":\\\"rea\\\",\\\"lastname\\\":\\\"mood\\\",\\\"email\\\":\\\"reamood@gmail.com\\\",\\\"account_id\\\":2090,\\\"deleted_at\\\":null,\\\"created_at\\\":\\\"2022-01-18T11:08:16.505Z\\\",\\\"updated_at\\\":\\\"2022-01-18T11:08:16.505Z\\\",\\\"phone_number_id\\\":null}\",\n" + 
				"            \"account_id\": 2090,\n" + 
				"            \"created_at\": \"2022-01-18T11:08:17.130Z\",\n" + 
				"            \"updated_at\": \"2022-01-18T11:08:17.130Z\"\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"klass\": \"v1/log\",\n" + 
				"            \"id\": \"AX5s342Qrpn4KQl9jtGL\",\n" + 
				"            \"method\": \"POST\",\n" + 
				"            \"url\": \"/v1/customers\",\n" + 
				"            \"status\": 200,\n" + 
				"            \"ip_address\": \"41.85.177.164\",\n" + 
				"            \"version\": \"Unknown\",\n" + 
				"            \"source\": \"Unknown\",\n" + 
				"            \"query\": \"{}\",\n" + 
				"            \"body\": \"{\\\"firstname\\\":\\\"rea\\\",\\\"email\\\":\\\"reamood@gmail.com\\\",\\\"lastname\\\":\\\"mood\\\",\\\"customer\\\":{\\\"firstname\\\":\\\"rea\\\",\\\"lastname\\\":\\\"mood\\\",\\\"email\\\":\\\"reamood@gmail.com\\\"}}\",\n" + 
				"            \"response\": \"{\\\"id\\\":5681,\\\"firstname\\\":\\\"rea\\\",\\\"lastname\\\":\\\"mood\\\",\\\"email\\\":\\\"reamood@gmail.com\\\",\\\"account_id\\\":2090,\\\"deleted_at\\\":null,\\\"created_at\\\":\\\"2022-01-18T11:08:16.505Z\\\",\\\"updated_at\\\":\\\"2022-01-18T11:08:16.505Z\\\",\\\"phone_number_id\\\":null}\",\n" + 
				"            \"account_id\": 2090,\n" + 
				"            \"created_at\": \"2022-01-18T11:08:17.130Z\",\n" + 
				"            \"updated_at\": \"2022-01-18T11:08:17.130Z\"\n" + 
				"        }\n" + 
				"    ]\n" + 
				"}");
		LogCollection logCollection = Log.all();

		assertSame(logCollection.getClass(), LogCollection.class);
	}

	@Test
	public void shouldReturnCurrencyRetrieved() throws Exception {

		wireMockManager.startTestServer("/logs/" + logId, "get", "{\"v1/log\":{\"klass\":\"v1/log\",\"id\":\"AX5s342Qrpn4KQl9jtGL\",\"method\":\"POST\",\"url\":\"/v1/customers\",\"status\":200,\"ip_address\":\"41.85.177.164\",\"version\":\"Unknown\",\"source\":\"Unknown\",\"query\":\"{}\",\"body\":\"{\\\"firstname\\\":\\\"rea\\\",\\\"email\\\":\\\"reamood@gmail.com\\\",\\\"lastname\\\":\\\"mood\\\",\\\"customer\\\":{\\\"firstname\\\":\\\"rea\\\",\\\"lastname\\\":\\\"mood\\\",\\\"email\\\":\\\"reamood@gmail.com\\\"}}\",\"response\":\"{\\\"id\\\":5681,\\\"firstname\\\":\\\"rea\\\",\\\"lastname\\\":\\\"mood\\\",\\\"email\\\":\\\"reamood@gmail.com\\\",\\\"account_id\\\":2090,\\\"deleted_at\\\":null,\\\"created_at\\\":\\\"2022-01-18T11:08:16.505Z\\\",\\\"updated_at\\\":\\\"2022-01-18T11:08:16.505Z\\\",\\\"phone_number_id\\\":null}\",\"account_id\":2090,\"created_at\":\"2022-01-18T11:08:17.130Z\",\"updated_at\":\"2022-01-18T11:08:17.130Z\"}}\n" + 
				"");

		Log log = Log.retrieve(logId);

		assertSame(log.getClass(), Log.class);
		assertNotNull(log.getId());
		assertEquals(log.getId(), logId);
	}

}
