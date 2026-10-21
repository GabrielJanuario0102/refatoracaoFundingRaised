package com.checkr.interviews.model;

import java.util.HashMap;
import java.util.Map;

public class Company {
    private String permalink;
    private String company_name;
    private String number_employees;
    private String category;
    private String city;
    private String state;
    private String funded_date;
    private String raised_amount;
    private String raised_currency;
    private String round;

    public Company() {
    };

    public Company(String permalink, String company_name, String number_employees, String category, String city, String state, String funded_date, String raised_amount, String raised_currency, String round) {
        this.permalink = permalink;
        this.company_name = company_name;
        this.number_employees = number_employees;
        this.category = category;
        this.city = city;
        this.state = state;
        this.funded_date = funded_date;
        this.raised_amount = raised_amount;
        this.raised_currency = raised_currency;
        this.round = round;
    }

    public String getPermalink() {
        return permalink;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getNumber_employees() {
        return number_employees;
    }

    public String getCategory() {
        return category;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getFunded_date() {
        return funded_date;
    }

    public String getRaised_amount() {
        return raised_amount;
    }

    public String getRaised_currency() {
        return raised_currency;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public void setRaised_currency(String raised_currency) {
        this.raised_currency = raised_currency;
    }

    public void setRaised_amount(String raised_amount) {
        this.raised_amount = raised_amount;
    }

    public void setFunded_date(String funded_date) {
        this.funded_date = funded_date;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setNumber_employees(String number_employees) {
        this.number_employees = number_employees;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public static Company fromCSVROW(String[] row) {
        String permaLink = row[0];
        String companyName = row[1];
        String numberEmployees = row[2];
        String category = row[3];
        String city = row[4];
        String state = row[5];
        String fundedState = row[6];
        String raisedAmount = row [7];
        String raisedCurrency = row[8];
        String round = row[9];

        return new Company(permaLink,companyName,numberEmployees,category,city,state,fundedState,raisedAmount,raisedCurrency,round);
    }

    public Map<String, String> createMap() {
        Map<String, String> mapped = new HashMap<>();
        mapped.put("permalink", getPermalink());
        mapped.put("company_name", getCompany_name());
        mapped.put("number_employees", getNumber_employees());
        mapped.put("category", getCategory());
        mapped.put("city", getCity());
        mapped.put("state", getState());
        mapped.put("funded_date", getFunded_date());
        mapped.put("raised_amount", getRaised_amount());
        mapped.put("raised_currency", getRaised_currency());
        mapped.put("round", getRound());
        return mapped;
    }
}
