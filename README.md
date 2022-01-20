# FedaPay Java client library

[![Maven Central](https://img.shields.io/maven-central/v/com.fedapay/fedapay-java)](https://mvnrepository.com/artifact/com.fedapay/fedapay-java)
[![JavaDoc](http://img.shields.io/badge/javadoc-reference-blue.svg)](https://fedapay.dev/fedapay-java)


The official [FedaPay][fed] Java client library.

## Installation

### Requirements

- Java 1.8 or later

### Gradle users

Add this dependency to your project's build file:

```groovy
implementation 'com.fedapay:fedapay-java:1.0.0'
```

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.fedapay</groupId>
  <artifactId>fedapay-java</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Others

You'll need to manually install the following JARs:

- The FedaPay JAR from <https://repo1.maven.org/maven2/com/fedapay/fedapay-java/>


## Usage

FedaPayExample.java

```java
import java.util.HashMap;
import java.util.Map;

import javax.naming.directory.InvalidAttributeIdentifierException;

public class MainClass {

	public static void main(String[] args) {
		
		try {
			
			FedaPay.setEnvironement("sandbox");
			
		} catch (InvalidAttributeIdentifierException e) {
			e.printStackTrace();
		}
		
		FedaPay.setApiKey("sk_sandbox_lWw2kwhv4apq-5N-QiTGMpy9");
		
		Map<String, Object> customerMap = new HashMap<String, Object>();
		
		customerMap.put("firstname", "John");
		customerMap.put("lastname", "Doe");
		customerMap.put("email", "johndoe@gmail.com");
		
		try {
			
			Customer customer = Customer.create(customerMap);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Get All transactions
		
		try {
			TransactionCollection transactionCollection = Transaction.all();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
```
##

--

[fed]: https://fedapay.com

<!--
# vim: set tw=79:
-->
