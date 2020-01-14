package com.qf.mapper;

import com.qf.entity.City;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CityMapper {
    public List<City> selectByPid(City city);
    public City selectById(Integer id);
    public City selectCity(Integer id);

}
