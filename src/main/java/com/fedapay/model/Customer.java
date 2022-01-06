package com.fedapay.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.collections.CustomerCollection;
import com.fedapay.net.All;
import com.fedapay.net.Create;
import com.fedapay.net.Delete;
import com.fedapay.net.Retrieve;
import com.fedapay.net.Update;
import com.fedapay.utile.CustomerModel;

public class Customer extends FedaPayObject {
	
	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	
	@JsonProperty("phone_number")
	private PhoneNumber phoneNumber;
	
	public Customer(String id, String firstname, String lastname, String email, String phone,PhoneNumber phoneNumber) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.phoneNumber = phoneNumber;
	}

	public Customer() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static CustomerCollection all() throws Exception{
		return All.all( new CustomerCollection(), "/customers");
	}
	
	public static Customer create(Map<String, Object> customerDataMap) throws Exception {
		Customer customer = Create.create(new CustomerModel(), "/customers", customerDataMap).getV1Customer(); 
		customer.setRawJsonResponse(Create.lastRequestResponse);
		return customer;
	}
	
	public static Customer retrieve(String customerId) throws Exception {
		Customer customer = Retrieve.retrieve(new CustomerModel(), "/customers", customerId).getV1Customer();
		customer.setRawJsonResponse(Retrieve.lastRequestResponse);
		return customer;
	}
	
	public static Customer update( String customerId, Map<String, Object> customerDataMap) throws Exception {
		Customer customer = Update.update(new CustomerModel(), "/customers", customerId, customerDataMap).getV1Customer();
		customer.setRawJsonResponse(Update.lastRequestResponse);
		return customer;
	}
	
	public Customer save() throws Exception {
		Customer customer = Update.update(new CustomerModel(), "/customers", this.id, this.toMap()).getV1Customer();
		customer.setRawJsonResponse(Update.lastRequestResponse);
		return customer;
	}
	
	public static String delete(String customerId) throws Exception {
		Delete.delete("/customers", customerId);
		return "Customer deleted";
	}
	
	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (this.id != null) {
			
			map.put("id", this.id);
			map.put("firstname", this.firstname);
			map.put("email", this.email);
			map.put("phone", this.phone);
			map.put("phone_number", this.phoneNumber);
		}
		return map;
	}
	
}
