package com.openrules;


public class GreetingServiceJava implements GreetingService {
	
	@Override
	public String generateGreetingFor(Customer customer) {
		return "Hello, " + customer.getName() + "!";
	}

}
