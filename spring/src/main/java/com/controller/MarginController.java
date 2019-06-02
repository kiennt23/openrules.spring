package com.controller;

import com.model.RuleInput;
import com.model.RuleOutput;
import com.service.MarginOpenRulesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MarginController {
	@Autowired
	private MarginOpenRulesService marginService;
	
	@RequestMapping(path="/margin", method= {RequestMethod.POST})
	public RuleOutput executeMargin(@RequestBody RuleInput ruleInput) {
		return marginService.executeRule(ruleInput);
	}
}




