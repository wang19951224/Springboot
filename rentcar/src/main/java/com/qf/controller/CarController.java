package com.qf.controller;

import com.qf.entity.Car;
import com.qf.service.impl.CarServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarServerImpl carServerImpl;
    @RequestMapping("/getAllCar")
    public List<Car> getAllCar(){
        return carServerImpl.getAllCar();
    }

    @RequestMapping("/getCarByCid")
    public List<Car> getCarByCid(String getid){
        return carServerImpl.getCarByCid(getid);
    }
    @RequestMapping("/getCarByCidAndNumber")
    public List<Car> getCarByCidAndNumber(String getid){
        return carServerImpl.getCarByCidAndNumber(getid);
    }
    @RequestMapping("/getCarById")
    public Car getCarById(String getid){
        return carServerImpl.getCarById(getid);
    }

}
