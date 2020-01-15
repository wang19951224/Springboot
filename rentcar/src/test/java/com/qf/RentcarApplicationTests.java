package com.qf;

import com.qf.entity.Car;
import com.qf.entity.Site;
import com.qf.service.impl.CarServerImpl;
import com.qf.service.impl.CityServiceImpl;
import com.qf.service.impl.OrderServiceImpl;
import com.qf.service.impl.UserServerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@SpringBootTest
class RentcarApplicationTests {


    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private CarServerImpl carServerImpl;
    @Autowired
    private CityServiceImpl cityService;


    @Autowired
    private UserServerImpl userServer;

    @Autowired
    private CarServerImpl carServer;

    @Test
    public void getAllCar(){
        List<Car> allCar = carServerImpl.getAllCar();
        System.out.println(allCar.size());
    }
    @Test
    public void TEST(){
        Integer uid=8;
        List<Site> site = orderService.getOrder(uid);
        for(Site s:site){
            System.out.println(s);
        }
    }
}
