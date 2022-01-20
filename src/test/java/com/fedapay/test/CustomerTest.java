package com.fedapay.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.fedapay.collections.CustomerCollection;
import com.fedapay.model.Customer;

public class CustomerTest {

	WireMockManager wireMockManager;
	
	private final String customerId = "5409";

	@Before
	public void initializeWireMockManager() throws Exception {
		wireMockManager = new WireMockManager();
	}

	@Test
	public void shouldReturnAccountCollection() throws Exception {
		wireMockManager.startTestServer("/customers", "get",
				"{\"v1/customers\":[{\"klass\":\"v1/customer\",\"id\":5409,\"firstname\":\"judicael\",\"lastname\":\"Doe\",\"full_name\":\"judicael Doe\",\"email\":\"judicael@fedapay.com\",\"account_id\":2090,\"created_at\":\"2021-12-10T11:06:03.030Z\",\"updated_at\":\"2021-12-10T11:11:41.435Z\",\"deleted_at\":null},{\"klass\":\"v1/customer\",\"id\":4004,\"firstname\":\"pp\",\"lastname\":\"online\",\"full_name\":\"pp online\",\"email\":\"pp.online@gmail.com\",\"account_id\":2090,\"created_at\":\"2021-08-04T14:17:54.260Z\",\"updated_at\":\"2021-08-04T14:17:54.260Z\",\"deleted_at\":null},{\"klass\":\"v1/customer\",\"id\":3885,\"firstname\":\"Fred\",\"lastname\":\"Red\",\"full_name\":\"Fred Red\",\"email\":\"d.j.bidossessi@gmail.com\",\"account_id\":2090,\"created_at\":\"2021-07-16T12:41:22.651Z\",\"updated_at\":\"2021-07-16T12:41:22.651Z\",\"deleted_at\":null},{\"klass\":\"v1/customer\",\"id\":3594,\"firstname\":\"shop\",\"lastname\":\"DAKIN\",\"full_name\":\"shop DAKIN\",\"email\":\"jdk@gmail.com\",\"account_id\":2090,\"created_at\":\"2021-06-02T15:40:13.758Z\",\"updated_at\":\"2021-06-02T15:40:13.758Z\",\"deleted_at\":null},{\"klass\":\"v1/customer\",\"id\":3505,\"firstname\":\"Judi\",\"lastname\":\"DAKIN\",\"full_name\":\"Judi DAKIN\",\"email\":\"johndoe@gmail.com\",\"account_id\":2090,\"created_at\":\"2021-05-18T12:34:26.505Z\",\"updated_at\":\"2021-05-20T15:30:38.769Z\",\"deleted_at\":null}],\"meta\":{\"current_page\":1,\"next_page\":null,\"prev_page\":null,\"per_page\":25,\"total_pages\":1,\"total_count\":5}}\n" + 
				"");

		CustomerCollection customerCollection = Customer.all();

		assertSame(customerCollection.getClass(), CustomerCollection.class);
		assertSame(customerCollection.getData().getClass(), ArrayList.class);
	}

	@Test
	public void shouldReturnAccountCreated() throws Exception {

		wireMockManager.startTestServer("/customers", "post", "{\"v1/customer\":{\"klass\":\"v1/customer\",\"id\":5409,\"firstname\":\"John\",\"lastname\":\"Doe\",\"full_name\":\"John Doe\",\"email\":\"johndoe@gmail.com\",\"account_id\":2090,\"created_at\":\"2021-12-10T11:06:03.030Z\",\"updated_at\":\"2021-12-10T11:11:41.435Z\",\"deleted_at\":null}}\n" + 
				"");

		Map<String, Object> customerMap = new HashMap<String, Object>();
		
		customerMap.put("firstname", "John");
		customerMap.put("lastname", "Doe");
		customerMap.put("email", "johndoe@gmail.com");
		
		Customer accountCreated = Customer.create(customerMap);

		assertSame(accountCreated.getClass(), Customer.class);
		assertNotNull(accountCreated.getId());
	}

	@Test
	public void shouldReturnAccountRetrieved() throws Exception {
		
		wireMockManager.startTestServer("/customers/"+customerId, "get", "{\"v1/customer\":{\"klass\":\"v1/customer\",\"id\":5409,\"firstname\":\"judicael\",\"lastname\":\"Doe\",\"full_name\":\"judicael Doe\",\"email\":\"judicael@fedapay.com\",\"account_id\":2090,\"created_at\":\"2021-12-10T11:06:03.030Z\",\"updated_at\":\"2021-12-10T11:11:41.435Z\",\"deleted_at\":null}}\n" + 
				"");

		Customer account = Customer.retrieve(customerId);

		assertSame(account.getClass(), Customer.class);
		assertNotNull(account.getId());
		assertEquals(account.getId(), customerId);
	}

	@Test
	public void shouldReturnAccountUpdated() throws Exception {
		
		wireMockManager.startTestServer("/customers/" + customerId, "put", "{\"v1/customer\":{\"klass\":\"v1/customer\",\"id\":5409,\"firstname\":\"James\",\"lastname\":\"Doe\",\"full_name\":\"James Doe\",\"email\":\"johndoe@gmail.com\",\"account_id\":2090,\"created_at\":\"2021-12-10T11:06:03.030Z\",\"updated_at\":\"2021-12-10T11:11:41.435Z\",\"deleted_at\":null}}\n" + 
				"");

		Customer customer = new Customer();
		customer.setId(customerId);
		customer.setEmail("johndoe@gmail.com");
		customer.setFirstname("James");
		
		Customer accountUpdated = Customer.update(customer.getId(), customer.toMap());

		assertSame(accountUpdated.getClass(), Customer.class);
		assertNotNull(accountUpdated.getId());
		assertEquals(accountUpdated.getId(), customerId);
	}

	@Test
	public void shouldReturnAccountSaved() throws Exception {
		
		wireMockManager.startTestServer("/customers/" + customerId, "put", "{\"v1/customer\":{\"klass\":\"v1/customer\",\"id\":5409,\"firstname\":\"James\",\"lastname\":\"Doe\",\"full_name\":\"James Doe\",\"email\":\"johndoe@gmail.com\",\"account_id\":2090,\"created_at\":\"2021-12-10T11:06:03.030Z\",\"updated_at\":\"2021-12-10T11:11:41.435Z\",\"deleted_at\":null}}\n" + 
				"");

		Customer customer = new Customer();
		customer.setId(customerId);
		customer.setEmail("johndoe@gmail.com");
		customer.setFirstname("James");
		
		Customer accountSaved = customer.save();

		assertSame(accountSaved.getClass(), Customer.class);
		assertNotNull(accountSaved.getId());
		assertEquals(accountSaved.getId(), customerId);
	}

	@Test
	public void shouldReturnAccountDeletedResponse() throws Exception {
		wireMockManager.startTestServer("/customers", "delete", "[]");

		String customerDeletedResponse = Customer.delete(customerId);

		assertSame(customerDeletedResponse.getClass(), String.class);
		assertNotNull(customerDeletedResponse);
	}

}
