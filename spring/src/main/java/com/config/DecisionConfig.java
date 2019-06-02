package com.config;

import com.openrules.ruleengine.Decision;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DecisionConfig {

    @Bean(name = "MarginDecision")
    public Decision marginDecision() {
        String fileName = "classpath:/repository/rules/DecisionMargin.xls";
        Decision decision = new Decision("MarginDecisionTable", fileName);
        decision.put("FEEL", "On");
        decision.put("report", "On");
        return decision;
    }
}
