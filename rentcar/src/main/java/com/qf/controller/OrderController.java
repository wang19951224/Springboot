package com.qf.controller;

import com.qf.entity.Car;
import com.qf.entity.City;
import com.qf.entity.Order;
import com.qf.entity.Site;
import com.qf.mapper.OrderMapper;
import com.qf.service.impl.CarServerImpl;
import com.qf.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    @RequestMapping("/total")

    public String test(String getid,String cid,String backid,String oprice){
         PRICE =  Integer.parseInt(oprice);
        System.out.println(oprice+"价格是");
        return "1";
    }
    @RequestMapping("/test")
    public Site total(Integer getid,Integer cid,Integer backid){
        List<Order> order = orderMapper.getOrder(cid, getid, backid);
        System.out.println(order.size());
        City getCity = cityService.selectById(getid);
        City city1 = cityService.selectCity(getid);
        final City backCity = cityService.selectById(backid);
        City city2 = cityService.selectCity(backid);
        String gid = getid.toString();
        Car carById = carServerImpl.getCarById(gid);
        String gCity = city1.getName()+"+"+getCity.getName();
        String bCity = city2.getName()+"+"+backCity.getName();
        String cname = carById.getName();
        String pid = UUID.randomUUID().toString();
        Site site = new Site();
       site.setOprice(PRICE);
        site.setPid(pid);
        site.setGetcity(gCity);
        site.setBackcity(bCity);
        site.setCname(cname);





        return site;
    }
}
