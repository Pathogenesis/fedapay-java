package com.fedapay.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.fedapay.collections.PageCollection;
import com.fedapay.model.Page;

public class PageTest {

	WireMockManager wireMockManager;

	private final String pageId = "270";

	@Before
	public void initializeWireMockManager() throws Exception {
		wireMockManager = new WireMockManager();
	}

	@Test
	public void shouldReturnPageCollection() throws Exception {
		wireMockManager.startTestServer("/pages", "get", "{\"v1/pages\":[{\"klass\":\"v1/page\",\"id\":270,\"name\":\"Fedapay java testing\",\"reference\":\"E8Lqtttl\",\"description\":\"Test fedapay-java lib\\n\",\"amount\":1000,\"published\":false,\"enable_phone_number\":false,\"callback_url\":null,\"custom_fields\":[],\"thank_you\":null,\"long_description\":\"\\u003cp\\u003eTest fedapay-java lib\\u003c/p\\u003e\",\"created_at\":\"2022-01-18T14:27:59.194Z\",\"updated_at\":\"2022-01-18T14:27:59.194Z\",\"deleted_at\":null}],\"meta\":{\"current_page\":1,\"next_page\":null,\"prev_page\":null,\"per_page\":25,\"total_pages\":1,\"total_count\":1}}\n" + 
				"");

		PageCollection pageCollection = Page.all();

		assertSame(pageCollection.getClass(), PageCollection.class);
		assertSame(pageCollection.getData().getClass(), ArrayList.class);
	}

	@Test
	public void shouldReturnPageCreated() throws Exception {

		wireMockManager.startTestServer("/pages", "post", "{\"v1/page\":{\"klass\":\"v1/page\",\"id\":270,\"name\":\"Fedapay java testing\",\"reference\":\"E8Lqtttl\",\"description\":\"Test fedapay-java lib\\n\",\"amount\":1000,\"published\":false,\"enable_phone_number\":false,\"callback_url\":null,\"custom_fields\":[],\"thank_you\":null,\"long_description\":\"\\u003cp\\u003eTest fedapay-java lib\\u003c/p\\u003e\",\"created_at\":\"2022-01-18T14:27:59.194Z\",\"updated_at\":\"2022-01-18T14:27:59.194Z\",\"deleted_at\":null}}\n" + 
				"");

		Map<String, Object> pageMap = new HashMap<String, Object>();

		Page pageCreated = Page.create(pageMap);

		assertSame(pageCreated.getClass(), Page.class);
		assertNotNull(pageCreated.getId());
	}

	@Test
	public void shouldReturnPageRetrieved() throws Exception {

		wireMockManager.startTestServer("/pages/" + pageId, "get", "{\"v1/page\":{\"klass\":\"v1/page\",\"id\":270,\"name\":\"Fedapay java testing\",\"reference\":\"E8Lqtttl\",\"description\":\"Test fedapay-java lib\\n\",\"amount\":1000,\"published\":false,\"enable_phone_number\":false,\"callback_url\":null,\"custom_fields\":[],\"thank_you\":null,\"long_description\":\"\\u003cp\\u003eTest fedapay-java lib\\u003c/p\\u003e\",\"created_at\":\"2022-01-18T14:27:59.194Z\",\"updated_at\":\"2022-01-18T14:27:59.194Z\",\"deleted_at\":null}}\n" + 
				"");

		Page page = Page.retrieve(pageId);

		assertSame(page.getClass(), Page.class);
		assertNotNull(page.getId());
		assertEquals(page.getId(), pageId);
	}

	@Test
	public void shouldReturnPageUpdated() throws Exception {

		wireMockManager.startTestServer("/pages/" + pageId, "put","{\"v1/page\":{\"klass\":\"v1/page\",\"id\":270,\"name\":\"Fedapay java testing\",\"reference\":\"E8Lqtttl\",\"description\":\"Test fedapay-java lib\\n\",\"amount\":1000,\"published\":false,\"enable_phone_number\":false,\"callback_url\":null,\"custom_fields\":[],\"thank_you\":null,\"long_description\":\"\\u003cp\\u003eTest fedapay-java lib\\u003c/p\\u003e\",\"created_at\":\"2022-01-18T14:27:59.194Z\",\"updated_at\":\"2022-01-18T14:27:59.194Z\",\"deleted_at\":null}}\n" + 
				"");

		Page page = new Page();
		page.setId(pageId);

		Page pageUpdated = Page.update(page.getId(), page.toMap());

		assertSame(pageUpdated.getClass(), Page.class);
		assertNotNull(pageUpdated.getId());
		assertEquals(pageUpdated.getId(), pageId);
	}

	@Test
	public void shouldReturnPageSaved() throws Exception {

		wireMockManager.startTestServer("/pages/" + pageId, "put", "{\"v1/page\":{\"klass\":\"v1/page\",\"id\":270,\"name\":\"Fedapay java testing\",\"reference\":\"E8Lqtttl\",\"description\":\"Test fedapay-java lib\\n\",\"amount\":1000,\"published\":false,\"enable_phone_number\":false,\"callback_url\":null,\"custom_fields\":[],\"thank_you\":null,\"long_description\":\"\\u003cp\\u003eTest fedapay-java lib\\u003c/p\\u003e\",\"created_at\":\"2022-01-18T14:27:59.194Z\",\"updated_at\":\"2022-01-18T14:27:59.194Z\",\"deleted_at\":null}}\n" + 
				"");

		Page page = new Page();
		page.setId(pageId);

		Page pageSaved = page.save();

		assertSame(pageSaved.getClass(), Page.class);
		assertNotNull(pageSaved.getId());
		assertEquals(pageSaved.getId(), pageId);
	}

	@Test
	public void shouldReturnPageDeletedResponse() throws Exception {
		wireMockManager.startTestServer("/pages", "delete", "[]");

		String pageDeletedResponse = Page.delete(pageId);

		assertSame(pageDeletedResponse.getClass(), String.class);
		assertNotNull(pageDeletedResponse);
	}

}
