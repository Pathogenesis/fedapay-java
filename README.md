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
implementation 'com.fedapay:fedapay-java:1.0.1'
```

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.fedapay</groupId>
  <artifactId>fedapay-java</artifactId>
  <version>1.0.1</version>
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
import com.fedapay.*

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		
		FedaPay.setEnvironement("sandbox");
		
		FedaPay.setApiKey("sk_sandbox_xxxxxxxxxxxxxxxxx");
		
		Map<String, Object> customerMap = new HashMap<String, Object>();
		
		customerMap.put("firstname", "John");
		customerMap.put("lastname", "Doe");
		customerMap.put("email", "johndoe@gmail.com");
		
		Customer customer = Customer.create(customerMap);
		
		//Get All transactions
		
		TransactionCollection transactionCollection = Transaction.all();
				
	}
}
```
##

--

[fed]: https://fedapay.com

<!--
# vim: set tw=79:
-->
