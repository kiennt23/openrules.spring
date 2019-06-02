package com.service;

import com.model.RuleInput;
import com.model.RuleOutput;
import com.openrules.ruleengine.Decision;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class MarginOpenRulesServiceImpl implements MarginOpenRulesService {

	@Autowired
	@Qualifier("MarginDecision")
	Decision decision;

	@Override
	public RuleOutput executeRule(RuleInput ruleInput) {
		decision.put("ruleInput", ruleInput);
		RuleOutput ruleOutput = new RuleOutput();
		decision.put("ruleOutput", ruleOutput);
		long start = System.nanoTime();
		decision.execute();
		long end = System.nanoTime();
		long duration = end - start;
		log.info("Total execution time: {}us", TimeUnit.NANOSECONDS.toMicros(duration));
		return ruleOutput;
	}
}


