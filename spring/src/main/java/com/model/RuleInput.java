package com.model;

import com.openrules.ruleengine.BusinessMap;
import com.openrules.ruleengine.BusinessMapImpl;
import com.openrules.ruleengine.DecisionObject;

import java.util.HashMap;

public class RuleInput implements DecisionObject {

    private String	countryCode;
    private String	currency;
    private String	tenor;
    private int	    time;
    private String	day;
    private String	date;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTenor() {
        return tenor;
    }

    public void setTenor(String tenor) {
        this.tenor = tenor;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private static final HashMap<String, String> attributes;
    static {
        attributes = new HashMap<>();
        attributes.put("countryCode","String");
        attributes.put("currency","String");
        attributes.put("tenor","String");
        attributes.put("time","int");
        attributes.put("day","String");
        attributes.put("date","String");
    }

    @Override
    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    @Override
    public void setAttribute(String name, String value) {
        if ("countryCode".equals(name)) {
            setCountryCode(value);
            return;
        }
        if ("currency".equals(name)) {
            setCurrency(value);
            return;
        }
        if ("tenor".equals(name)) {
            setTenor(value);
            return;
        }
        if ("time".equals(name)) {
            setTime(Integer.parseInt(value));
            return;
        }
        if ("day".equals(name)) {
            setDay(value);
            return;
        }
        if ("date".equals(name)) {
            setDate(value);
            return;
        }
        throw new RuntimeException("DecisionObject.setAttribute("	+ name + "," + value + ") failed - unknown attribute");
    }

    @Override
    public String getAttribute(String name) {
        if ("countryCode".equals(name)) {
            return getCountryCode();
        }
        if ("currency".equals(name)) {
            return getCurrency();
        }
        if ("tenor".equals(name)) {
            return getTenor();
        }
        if ("time".equals(name)) {
            return "" + getTime();
        }
        if ("day".equals(name)) {
            return getDay();
        }
        if ("date".equals(name)) {
            return getDate();
        }
        throw new RuntimeException("DecisionObject.getAttribute(" + name + ") failed - unknown attribute");
    }

    static public String getClassName() {
        return "RuleInput";
    }

    @Override
    public String toString() {
        return "RuleInput{" +
                "countryCode='" + countryCode + '\'' +
                ", currency='" + currency + '\'' +
                ", tenor='" + tenor + '\'' +
                ", time=" + time +
                ", day='" + day + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    static public BusinessMap createBusinessMap() {
        String className = RuleInput.getClassName();
        return new BusinessMapImpl(className, new RuleInput());
    }

    static public DecisionObject createDecisionObject() {
        return new RuleInput();
    }
}
