package com.example.covidboot.controller;

import com.example.covidboot.CovidBootApplication;
import com.example.covidboot.entity.CovidDataBean;
import com.example.covidboot.entity.MonthDataBean;
import com.example.covidboot.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Covid19")
public class CovidController {
    @Autowired
    CovidService service;

    @RequestMapping("/AllData")
    @ResponseBody
    public List<CovidDataBean> getAllData(){
        return service.getAllDataBean();
    }

    @RequestMapping("/getByMonth")
    @ResponseBody
    public List<CovidDataBean> getMonth(long month){
        return service.getByMonth(month);
    }

    @RequestMapping("/getAllByMonth")
    @ResponseBody
    public List<CovidDataBean> getAllByMonth(long month){
        return service.getAllByMonth(month);
    }

    @RequestMapping("getByCountry")
    @ResponseBody
    public List<CovidDataBean> getCountry(String country){
        return service.getByCountry(country);
    }


}
