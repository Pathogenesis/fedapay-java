package com.fedapay.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.fedapay.collections.BalanceCollection;
import com.fedapay.model.Balance;

public class BalanceTest {

	WireMockManager wireMockManager;

	private final String balanceId = "40075";

	@Before
	public void initializeWireMockManager() throws Exception {
		wireMockManager = new WireMockManager();
	}

	@Test
	public void shouldReturnBalanceCollection() throws Exception {
		wireMockManager.startTestServer("/balances", "get",
				"{\"v1/balances\":[{\"klass\":\"v1/balance\",\"id\":40075,\"amount\":0,\"mode\":null,\"created_at\":\"2021-11-29T15:38:47.733Z\",\"updated_at\":\"2021-11-29T15:38:47.733Z\"},{\"klass\":\"v1/balance\",\"id\":37143,\"amount\":0,\"mode\":\"free_sn\",\"created_at\":\"2021-11-29T15:10:22.725Z\",\"updated_at\":\"2021-11-29T15:10:22.725Z\"},{\"klass\":\"v1/balance\",\"id\":32447,\"amount\":0,\"mode\":null,\"created_at\":\"2021-10-28T13:12:46.140Z\",\"updated_at\":\"2021-10-28T13:12:46.140Z\"},{\"klass\":\"v1/balance\",\"id\":28321,\"amount\":0,\"mode\":\"orabank_tpe\",\"created_at\":\"2021-09-30T11:05:35.208Z\",\"updated_at\":\"2021-09-30T11:05:35.208Z\"},{\"klass\":\"v1/balance\",\"id\":25229,\"amount\":0,\"mode\":\"togocel\",\"created_at\":\"2021-09-21T15:29:58.453Z\",\"updated_at\":\"2021-09-21T15:29:58.453Z\"},{\"klass\":\"v1/balance\",\"id\":18810,\"amount\":0,\"mode\":\"ecobank_tpe\",\"created_at\":\"2021-05-18T12:30:02.291Z\",\"updated_at\":\"2021-05-18T12:30:02.291Z\"},{\"klass\":\"v1/balance\",\"id\":18809,\"amount\":0,\"mode\":\"orange_sn\",\"created_at\":\"2021-05-18T12:30:02.280Z\",\"updated_at\":\"2021-05-18T12:30:02.280Z\"},{\"klass\":\"v1/balance\",\"id\":18808,\"amount\":0,\"mode\":\"orange_ci\",\"created_at\":\"2021-05-18T12:30:02.269Z\",\"updated_at\":\"2021-05-18T12:30:02.269Z\"},{\"klass\":\"v1/balance\",\"id\":18807,\"amount\":0,\"mode\":\"moov_tg\",\"created_at\":\"2021-05-18T12:30:02.258Z\",\"updated_at\":\"2021-05-18T12:30:02.258Z\"},{\"klass\":\"v1/balance\",\"id\":18806,\"amount\":0,\"mode\":\"moov\",\"created_at\":\"2021-05-18T12:30:02.246Z\",\"updated_at\":\"2021-05-18T12:30:02.246Z\"},{\"klass\":\"v1/balance\",\"id\":18805,\"amount\":0,\"mode\":\"stripe_gw\",\"created_at\":\"2021-05-18T12:30:02.234Z\",\"updated_at\":\"2021-05-18T12:30:02.234Z\"},{\"klass\":\"v1/balance\",\"id\":18804,\"amount\":0,\"mode\":\"uba\",\"created_at\":\"2021-05-18T12:30:02.220Z\",\"updated_at\":\"2021-05-18T12:30:02.220Z\"},{\"klass\":\"v1/balance\",\"id\":18803,\"amount\":0,\"mode\":\"mtn_ci\",\"created_at\":\"2021-05-18T12:30:02.208Z\",\"updated_at\":\"2021-05-18T12:30:02.208Z\"},{\"klass\":\"v1/balance\",\"id\":18802,\"amount\":1672313,\"mode\":\"mtn\",\"created_at\":\"2021-05-18T12:30:02.192Z\",\"updated_at\":\"2021-05-18T12:30:02.192Z\"}]}\n" + ""
				);

		BalanceCollection balanceCollection = Balance.all();

		assertSame(balanceCollection.getClass(), BalanceCollection.class);
		assertSame(balanceCollection.getData().getClass(), ArrayList.class);
	}

	@Test
	public void shouldReturnBalanceRetrieved() throws Exception {

		wireMockManager.startTestServer("/balances/" + balanceId , "get", "{\"v1/balance\":{\"klass\":\"v1/balance\",\"id\":40075,\"amount\":0,\"mode\":null,\"created_at\":\"2021-11-29T15:38:47.733Z\",\"updated_at\":\"2021-11-29T15:38:47.733Z\"}}\n" + 
				"");

		Balance balance = Balance.retrieve(balanceId);

		assertSame(balance.getClass(), Balance.class);
		assertNotNull(balance.getId());
		assertEquals(balance.getId(), balanceId);
	}
}
