package com.model;

import com.openrules.ruleengine.BusinessMap;
import com.openrules.ruleengine.BusinessMapImpl;
import com.openrules.ruleengine.DecisionObject;

import java.util.HashMap;

public class RuleOutput implements DecisionObject {

    private int	    pips;
    private String	message;

    public int getPips() {
        return pips;
    }

    public void setPips(int pips) {
        this.pips = pips;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private static final HashMap<String, String> attributes;
    static {
        attributes = new HashMap<>();
        attributes.put("pips","int");
        attributes.put("message","String");
    }

    @Override
    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    @Override
    public void setAttribute(String name, String value) {
        if ("pips".equals(name)) {
            setPips(Integer.parseInt(value));
            return;
        }
        if ("message".equals(name)) {
            setMessage(value);
            return;
        }

        throw new RuntimeException("DecisionObject.setAttribute("	+ name + "," + value + ") failed - unknown attribute");
    }

    @Override
    public String getAttribute(String name) {
        if ("pips".equals(name)) {
            return "" + getPips();
        }
        if ("message".equals(name)) {
            return getMessage();
        }
        throw new RuntimeException("DecisionObject.getAttribute(" + name + ") failed - unknown attribute");
    }

    static public String getClassName() {
        return "RuleOutput";
    }

    @Override
    public String toString() {
        return "RuleOutput{" +
                "pips=" + pips +
                ", message='" + message + '\'' +
                '}';
    }

    static public BusinessMap createBusinessMap() {
        String className = RuleOutput.getClassName();
        return new BusinessMapImpl(className, new RuleOutput());
    }

    static public DecisionObject createDecisionObject() {
        return new RuleOutput();
    }
}
