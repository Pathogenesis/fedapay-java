package com.fedapay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class PhoneNumber
 *
 * @property int id
 * @property String number
 * @property String country
 * @property String created_at
 * @property String updated_at
 *
 * @package com.fedapay.model
 */

public class PhoneNumber {

	private String id;
	private String number;
	private String country;
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("updated_at")
	private String updatedAt;
	
	public PhoneNumber() {
		super();
	}

	public PhoneNumber(String id, String number, String country, String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.number = number;
		this.country = country;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String created_at) {
		this.createdAt = created_at;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
