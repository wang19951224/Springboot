package com.qf;

import com.qf.entity.Car;
import com.qf.service.impl.CarServerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@SpringBootTest
class RentcarApplicationTests {


    @Autowired
    private CarServerImpl carServerImpl;
    @Test
    public void getAllCar(){
        List<Car> allCar = carServerImpl.getAllCar();
        System.out.println(allCar.size());
    }

}
