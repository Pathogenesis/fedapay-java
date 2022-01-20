package com.fedapay.model;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedapay.utile.EventModel;
import com.fedapay.utile.Serializer;
import com.fedapay.utile.StringUtils;


public class WebhookSignature {

	 private String id;
	 @JsonProperty("public_key")
	 private String publicKey;
	 @JsonProperty("private_key")
	 private String privateKey;
	 @JsonProperty("created_at")
	 private String createdAt;
	 @JsonProperty("updated_at")
	 private String updatedAt;
	 
	 
	 public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public static long getDefaultTolerance() {
		return DEFAULT_TOLERANCE;
	}

	public static String getAlgorithm() {
		return ALGORITHM;
	}



	private static final long DEFAULT_TOLERANCE = 300;
	 public static final String ALGORITHM = "HmacSHA256";
	  /**
	   * Returns an Event instance using the provided JSON payload. Throws a JsonSyntaxException if the
	   * payload is not valid JSON, and a SignatureVerificationException if the signature verification
	   * fails for any reason.
	   *
	   * @param payload the payload sent by FedaPay.
	   * @param sigHeader the contents of the signature header sent by FedaPay.
	   * @param secret secret used to generate the signature.
	   * @return the Event instance
	   */
	  public static Event constructEvent(String payload, String sigHeader, String secret) throws Exception {
	    return constructEvent(payload, sigHeader, secret, DEFAULT_TOLERANCE); 
	  }

	  
	  public static Event constructEvent(String payload, String sigHeader, String secret, long tolerance) throws Exception {
	    Event event = Serializer.allSerializer(new EventModel(), payload).getData();
	    Signature.verifyHeader(payload, sigHeader, secret, tolerance);
	    return event;
	  }

	  public static final class Signature {
	    public static final String EXPECTED_SCHEME = "s";

	    
	    public static boolean verifyHeader(
	        String payload, String sigHeader, String secret, long tolerance)
	        throws Exception {
	      // Get timestamp and signatures from header
	      long timestamp = getTimestamp(sigHeader);
	      List<String> signatures = getSignatures(sigHeader, EXPECTED_SCHEME);
	      if (timestamp <= 0) {
	        throw new java.lang.Exception("Unable to extract timestamp and signatures from header" + sigHeader);
	   
	      }
	      if (signatures.size() == 0) {
	        throw new java.lang.Exception("No signatures found with expected scheme" + sigHeader);
	      }

	      // Compute expected signature

	      String signedPayload = "" + timestamp  + "."+ payload;

	      String expectedSignature;
	      try {
	        expectedSignature = computeSignature(signedPayload, secret);
	      } catch (Exception e) {
	        throw new java.lang.Exception("Unable to compute signature for payload" + sigHeader);
	      }

	      // Check if expected signature is found in list of header's signatures
	      boolean signatureFound = false;
	      for (String signature : signatures) {
	        if (StringUtils.secureCompare(expectedSignature, signature)) {
	          signatureFound = true;
	          break;
	        }
	      }
	      if (!signatureFound) {
	        throw new java.lang.Exception ("No signatures found matching the expected signature for payload" + sigHeader);
	      }

	      // Check tolerance
	      if ((tolerance > 0) && (timestamp < (Util.getTimeNow() - tolerance))) {
	        throw new java.lang.Exception("Timestamp outside the tolerance zone" + sigHeader);
	      }

	      return true;
	    }

	   
	    private static long getTimestamp(String sigHeader) {
	      String[] items = sigHeader.split(",", -1);

	      for (String item : items) {
	        String[] itemParts = item.split("=", 2);
	        if (itemParts[0].equals("t")) {
	          return Long.parseLong(itemParts[1]);
	        }
	      }

	      return -1;
	    }

	   
	    private static List<String> getSignatures(String sigHeader, String scheme) {
	      List<String> signatures = new ArrayList<String>();
	      String[] items = sigHeader.split(",", -1);

	      for (String item : items) {
	        String[] itemParts = item.split("=", 2);
	        if (itemParts[0].equals(scheme)) {
	          signatures.add(itemParts[1]);
	        }
	      }

	      return signatures;
	    }

	   
	    private static String computeSignature(String payload, String secret)
	        throws Exception {
	      return Util.computeHmacSha256(secret, payload);    //Util.computeHmacSha256(secret, payload);
	    }
	    
	  }
	  
	  
	 
	 public static final class Util {
		    
		    public static String computeHmacSha256(String key, String message)
		        throws NoSuchAlgorithmException, InvalidKeyException {
		      Mac hasher = Mac.getInstance("HmacSHA256");
		      hasher.init(new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
		      byte[] hash = hasher.doFinal(message.getBytes(StandardCharsets.UTF_8));
		      String result = "";
		      for (byte b : hash) {
		        result += Integer.toString((b & 0xff) + 0x100, 16).substring(1);
		      }
		      return result;
		    }

		    
		    public static long getTimeNow() {
		      long time = System.currentTimeMillis() / 1000L;
		      return time;
		    }
		  }
}
