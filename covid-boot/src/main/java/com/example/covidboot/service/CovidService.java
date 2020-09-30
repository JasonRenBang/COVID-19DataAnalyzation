package com.example.covidboot.service;

import com.example.covidboot.dao.CovidMapper;
import com.example.covidboot.entity.CovidDataBean;
import com.example.covidboot.entity.MonthDataBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidService {
    final
    CovidMapper mapper;

    public CovidService(CovidMapper mapper) {
        this.mapper = mapper;
    }

    public List<CovidDataBean> getAllDataBean(){
        return mapper.getAllDataBean();
    }

    public List<CovidDataBean> getByMonth(long month){
        return mapper.getByMonth(month);

    }

    public List<CovidDataBean> getAllByMonth(long month){
        return mapper.getAllByMonth(month);
    }

    public List<CovidDataBean> getByCountry(String country){
        return mapper.getByCountry(country);
    }

    public MonthDataBean getMonthDataBean(){
        MonthDataBean monthDataBean = new MonthDataBean();
        monthDataBean.setMonth(mapper.getMonth());
        monthDataBean.setMonthlyCase(mapper.getMonthlyCase());
       // monthDataBean.setMonthlyDeath(monthDataBean.getMonthlyDeath());
        return monthDataBean;
    }

}
