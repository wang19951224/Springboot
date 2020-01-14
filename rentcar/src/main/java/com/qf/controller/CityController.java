package com.qf.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.entity.City;
import com.qf.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityServiceImpl cityService;
    @RequestMapping("/selectPid")
    public  List<City> selectPid(City city) throws JsonProcessingException {
        List<City> cities = cityService.selectByPid(city);
        return cities;
    }

    @RequestMapping("/selectId")
    public List<City> selectId(Integer getid,Integer backid){
        City getCity = cityService.selectById(getid);
        City city1 = cityService.selectCity(getid);
        final City backCity = cityService.selectById(backid);
        City city2 = cityService.selectCity(backid);
        List<City> list = new ArrayList<>();
        list.add(getCity);
        list.add(city1);
        list.add(city2);
        list.add(backCity);
        City city = cityService.selectById(getid);
        if(city!=null){
            city.setCode(1);
        }
        return list;
    }
}
