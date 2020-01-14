package com.qf.mapper;

import com.qf.entity.Car;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarMapper {
    public List<Car> getAllCar();
    public List<Car> getCarByCid(String id);
    public List<Car> getCarByCidAndNumber(String id);
    public Car getCarById(String id);
}
