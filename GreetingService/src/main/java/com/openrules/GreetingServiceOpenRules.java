package com.openrules;

import com.openrules.ruleengine.Decision;

public class GreetingServiceOpenRules implements GreetingService {
	
	Decision decision;
	
	public GreetingServiceOpenRules() {
		System.setProperty("OPENRULES_MODE", "Solve");
		String fileName = "classpath:/rules/Goals.xls";
		String decisionName = "DecisionHelloStatement";
		decision = new Decision(decisionName,fileName);
		decision.put("FEEL", "On");
		decision.put("report", "On");
		decision.put("trace", "On");
	}
	
	@Override
	public String generateGreetingFor(Customer customer) {
		decision.put("Customer", customer);
		GreetingResponse response = new GreetingResponse();
		decision.put("GreetingResponse", response);
		decision.execute();
		return response.getHelloStatement();
	}
}


