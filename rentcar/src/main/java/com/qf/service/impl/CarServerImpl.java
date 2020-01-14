package com.qf.service.impl;

import com.qf.entity.Car;
import com.qf.mapper.CarMapper;
import com.qf.service.CarServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServerImpl implements CarServer {
    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> getAllCar() {
        return carMapper.getAllCar();
    }

    @Override
    public List<Car> getCarByCid(String id){
        return carMapper.getCarByCid(id);
    }

    @Override
    public List<Car> getCarByCidAndNumber(String id) {
        return carMapper.getCarByCidAndNumber(id);
    }

    @Override
    public Car getCarById(String id) {
        return carMapper.getCarById(id);
    }
}
