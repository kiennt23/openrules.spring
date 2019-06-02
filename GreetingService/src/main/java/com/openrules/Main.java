package com.openrules;

/**
 * A simple Java launcher for Goals.xls with data defined in Java
 * 
 */

import com.openrules.ruleengine.Decision;

public class Main { 

	public static void main(String[] args) {

		System.setProperty("OPENRULES_MODE", "Solve");
		String fileName = "classpath:/Goals.xls";
		String decisionName = "DecisionHelloStatement";
		Decision decision = new Decision(decisionName,fileName);
		decision.put("FEEL", "On");
		decision.put("report", "On");
		
		Customer customer = new Customer();
		customer.setName("Robinson");
		customer.setGender("Female");
		customer.setMaritalStatus("Married");
		customer.setCurrentHour(20);
		
		GreetingResponse response = new GreetingResponse();
		
		decision.put("Customer", customer);
		decision.put("GreetingResponse", response);
		decision.execute();
		
		decision.log("\nProduced Hello Statement: " + response.getHelloStatement());
	}
}


