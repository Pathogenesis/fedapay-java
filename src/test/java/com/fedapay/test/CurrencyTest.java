package com.fedapay.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.fedapay.collections.CurrencyCollection;
import com.fedapay.model.Currency;

public class CurrencyTest {

	WireMockManager wireMockManager;

	private final String currencyId = "1";

	@Before
	public void initializeWireMockManager() throws Exception {
		wireMockManager = new WireMockManager();
	}

	@Test
	public void shouldReturnCurrencyCollection() throws Exception {
		wireMockManager.startTestServer("/currencies", "get",
				"{\"v1/currencies\":[{\"klass\":\"v1/currency\",\"id\":1,\"name\":\"FCFA\",\"iso\":\"XOF\",\"code\":952,\"prefix\":null,\"suffix\":\"CFA\",\"div\":1,\"default\":true,\"created_at\":\"2018-05-27T21:26:23.618Z\",\"updated_at\":\"2018-05-27T21:26:23.618Z\"}]}\n" + 
				"");

		CurrencyCollection currencyCollection = Currency.all();

		assertSame(currencyCollection.getClass(), CurrencyCollection.class);
		assertSame(currencyCollection.getData().getClass(), ArrayList.class);
	}

	@Test
	public void shouldReturnCurrencyRetrieved() throws Exception {

		wireMockManager.startTestServer("/currencies/" + currencyId, "get", "{\"v1/currency\":{\"klass\":\"v1/currency\",\"id\":1,\"name\":\"FCFA\",\"iso\":\"XOF\",\"code\":952,\"prefix\":null,\"suffix\":\"CFA\",\"div\":1,\"default\":true,\"created_at\":\"2018-05-27T21:26:23.618Z\",\"updated_at\":\"2018-05-27T21:26:23.618Z\"}}\n" + 
				"");

		Currency currency = Currency.retrieve(currencyId);

		assertSame(currency.getClass(), Currency.class);
		assertNotNull(currency.getId());
		assertEquals(currency.getId(), currencyId);
	}
}
