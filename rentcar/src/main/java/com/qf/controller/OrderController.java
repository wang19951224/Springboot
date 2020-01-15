package com.qf.controller;

import com.qf.entity.Car;
import com.qf.entity.City;
import com.qf.entity.Site;
import com.qf.entity.User;
import com.qf.mapper.OrderMapper;
import com.qf.service.impl.CarServerImpl;
import com.qf.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
     private Integer PRICE=0;
     @Autowired
     private OrderMapper orderMapper;
    @Autowired
    private CarServerImpl carServerImpl;
    @Autowired
    private CityServiceImpl cityService;

    @RequestMapping("/test")
    public Site total(Integer getid,Integer cid,Integer backid){


            return null;
    }
}
