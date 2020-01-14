package com.qf.service;

import com.qf.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarServer {
    public List<Car> getAllCar();
    public List<Car> getCarByCid(String id);
    public List<Car> getCarByCidAndNumber(String id);
    public Car getCarById(String id);
}
