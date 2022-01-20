package com.fedapay.test;

import com.fedapay.model.FedaPay;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.naming.directory.InvalidAttributeIdentifierException;

import org.junit.Rule;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.junit.WireMockRule;


public class WireMockManager {


	public static int port = 8089 ;
	public static String host = "localhost";
	public static WireMockServer wireMockServer = new WireMockServer(port);
	
	public static void beforClassMethod() throws Exception {
		
	}

	public WireMockManager() throws Exception {
		wireMockServer.start();
		configureFor( host, port);
		FedaPay.setEnvironement("localTest");
		FedaPay.setApiKey("xxx");
	}
	
	public void startTestServer(String stubPath, String requestMethod, String responseData) throws Exception {
		
		
		ResponseDefinitionBuilder defBuilder = new ResponseDefinitionBuilder();
		defBuilder.withBody(responseData);
		
		switch (requestMethod) {
		
		case "get":
			configureFor( host, port);
			wireMockServer.start();
			stubFor(get(urlEqualTo("/v1" + stubPath)).willReturn(defBuilder));
			break;
			
		case "post":
			configureFor( host, port);
			wireMockServer.start();
			stubFor(post(urlEqualTo("/v1" + stubPath)).willReturn(defBuilder));
			break;
			
		case "put":
			configureFor( host, port);
			wireMockServer.start();
			stubFor(put(urlEqualTo("/v1" + stubPath)).willReturn(defBuilder));
			break;
			
		case "delete":
			stubFor(delete(urlEqualTo("/v1" + stubPath)).willReturn(defBuilder));
			break;
			
		default:
			break;
		}
		
	}
	
	public int changePort() throws Exception {
		
		int newPort = (int) ((Math.random() * (9999 - 1)) + 1);
		
		FileOutputStream out = new FileOutputStream("fedapay.config.properties");
		
		Properties props = new Properties();

		props.setProperty("localTest", "http://localhost:" + newPort);
		props.store(out, null);
		out.close();
		
		return newPort;
	}
	
	public void stopServer() {
		wireMockServer.stop();
		wireMockServer = null;
	}
	
}
