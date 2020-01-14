package com.qf.service;

import com.qf.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CItyService {
    public List<City> selectByPid(City city);
    public City selectById(Integer id);
    public City selectCity(Integer id);
}
