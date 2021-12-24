package com.fedapay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.collections.LogCollection;
import com.fedapay.net.All;
import com.fedapay.net.Retrieve;
import com.fedapay.utile.LogModel;


/**
 * Class Log
 *
 * @property int id
 * @property String method
 * @property String url
 * @property String status
 * @property String ip_address
 * @property String version
 * @property String source
 * @property String query
 * @property String body
 * @property String response
 * @property int account_id
 * @property String created_at
 * @property String updated_at
 *
 * @package com.fedapay.model
 */

public class Log extends FedaPayObject {

	 private String id;
	 private String method;
	 private String url;
	 private String status;
	 @JsonProperty("ip_address")
	 private String ipAddress;
	 private String version;
	 private String source;
	 private String query;
	 private String body;
	 private String response;
	 @JsonProperty("account_id")
	 private String accountId;
	 @JsonProperty("created_at")
	 private String createdAt;
	 
	public Log() {
		super();
	}

	public Log(String id, String method, String url, String status, String ipAddress, String version, String source,
			String query, String body, String response, String accountId, String createdAt) {
		super();
		this.id = id;
		this.method = method;
		this.url = url;
		this.status = status;
		this.ipAddress = ipAddress;
		this.version = version;
		this.source = source;
		this.query = query;
		this.body = body;
		this.response = response;
		this.accountId = accountId;
		this.createdAt = createdAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public static LogCollection all() throws Exception {
		return All.all(new LogCollection(), "/logs");
	}
	 
	public static Log retrieve(String logId) throws Exception {
		Log log = Retrieve.retrieve(new LogModel(), "/logs", logId).getV1Log();
		log.setRawJsonResponse(Retrieve.lastRequestResponse);
		return log;
	}
}
