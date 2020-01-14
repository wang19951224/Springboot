package com.qf.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.entity.Car;
import com.qf.entity.City;
import com.qf.entity.User;
import com.qf.service.impl.CarServerImpl;
import com.qf.service.impl.CityServiceImpl;
import com.qf.service.impl.UserServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServerImpl userServer;
    @Autowired
    private CityServiceImpl cityService;
    @Autowired
    private CarServerImpl carServer;
    @RequestMapping("/index")
    public String index(HttpSession session){
        List<Car> allCar = carServer.getAllCar();
        return "/pagehome/index";
    }



    @RequestMapping("/login")
    @ResponseBody
    public User login(User user){
        User userByNameAndPWD = userServer.getUserByNameAndPWD(user);

        if(userByNameAndPWD!=null){
            userByNameAndPWD.setCode(1);
        }
        return userByNameAndPWD;
    }
}
