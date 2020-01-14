package com.qf.service.impl;

import com.qf.entity.City;
import com.qf.mapper.CityMapper;
import com.qf.service.CItyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CItyService {
    @Autowired
    public CityMapper cityMapper;

    @Override
    public List<City> selectByPid(City city) {
        return cityMapper.selectByPid(city);
    }

    @Override
    public City selectById(Integer id) {
        return cityMapper.selectById(id);
    }

    @Override
    public City selectCity(Integer id) {
        return cityMapper.selectCity(id);
    }
}
