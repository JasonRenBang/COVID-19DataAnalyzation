package com.example.covidboot.entity;

public class CovidDataBean {
    private String month_Country_Key;
    private long month;
    private String country;
    private long monthly_Case;
    private long monthly_Death;

    public CovidDataBean(){

    }

    public CovidDataBean(String month_Country_Key, long month, String country, long monthly_Case, long monthly_Death) {
        this.month_Country_Key = month_Country_Key;
        this.month = month;
        this.country = country;
        this.monthly_Case = monthly_Case;
        this.monthly_Death = monthly_Death;
    }

    public String getMonth_Country_Key() {
        return month_Country_Key;
    }

    public void setMonth_Country_Key(String month_Country_Key) {
        this.month_Country_Key = month_Country_Key;
    }

    public long getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getMonthly_Case() {
        return monthly_Case;
    }

    public void setMonthly_Case(int monthly_Case) {
        this.monthly_Case = monthly_Case;
    }

    public long getMonthly_Death() {
        return monthly_Death;
    }

    public void setMonthly_Death(int monthly_Death) {
        this.monthly_Death = monthly_Death;
    }

    @Override
    public String toString() {
        return "China{" +
                "month_Country_Key='" + month_Country_Key + '\'' +
                ", month=" + month +
                ", country='" + country + '\'' +
                ", monthly_Case=" + monthly_Case +
                ", monthly_Death=" + monthly_Death +
                '}';
    }
}

