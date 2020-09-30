package com.example.covidboot.dao;

import com.example.covidboot.entity.CovidDataBean;
import com.example.covidboot.entity.MonthDataBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CovidMapper {

    @Select("select * from t_covid")
    List<CovidDataBean> getAllDataBean();

    @Select("select MONTH,COUNTRY,MONTHLY_CASE from t_covid where MONTH=#{month}")
    List<CovidDataBean> getByMonth(long month);

    @Select("select * from t_covid where MONTH= #{month}")
    List<CovidDataBean> getAllByMonth(long month);

    @Select("select MONTHLY_CASE from t_covid")
    List<Long> getMonthlyCase();

    @Select("select MONTHLY_DEATH from t_covid")
    List<Long> getMonthlyDeath();

    @Select("select MONTH from t_covid")
    List<Long> getMonth();

    @Select("select * from t_covid where COUNTRY = #{COUNRTY}")
    List<CovidDataBean> getByCountry(String country);



}
