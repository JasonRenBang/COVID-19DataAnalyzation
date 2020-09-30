package com.example.covidboot.entity;

import java.util.List;

public class MonthDataBean {

    private List<Long> monthlyCase;
    private List<Long> monthlyDeath;
    private List<Long> month;
    private List<String>country;

    public List<Long> getMonthlyCase(){return monthlyCase;}
    public void setMonthlyCase(List<Long> monthlyCase) { this.monthlyCase = monthlyCase; }

    public List<Long> getMonthlyDeath(){return monthlyDeath;}
    public void setMonthlyDeath(List<Long> monthlyDeath) {
        this.monthlyDeath = monthlyDeath;
    }

    public List<Long> getMonth(){return month;}
    public void setMonth(List<Long> monthly) {
        this.month= monthly;
    }

    public List<String> getCountry() { return country; }
    public void setCountry(List<String> country) { this.country = country; }




}
