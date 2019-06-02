package com.service;

import com.model.RuleInput;
import com.model.RuleOutput;

public interface MarginOpenRulesService {
	RuleOutput executeRule(RuleInput ruleInput);
}
