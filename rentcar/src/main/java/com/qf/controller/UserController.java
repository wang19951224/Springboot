package com.qf.controller;

import com.qf.entity.Car;
import com.qf.entity.Order;
import com.qf.entity.Site;
import com.qf.entity.User;
import com.qf.mapper.OrderMapper;
import com.qf.service.UserService;
import com.qf.service.impl.CarServerImpl;
import com.qf.service.impl.CityServiceImpl;
import com.qf.service.impl.OrderServiceImpl;
import com.qf.service.impl.UserServerImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private Integer PRICE=0;
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

    @RequestMapping("/toLogin")
    public String toLogin(){

        return "/pagehome/login";
    }
    @RequestMapping("/refuse")
    public String refuse(){

        return "/pagehome/error";
    }
    @RequestMapping("/index")
    public String index(HttpSession session){
        List<Car> allCar = carServer.getAllCar();
        return "/pagehome/index";
    }

    private User user1;

    @RequestMapping("/login")
    @ResponseBody
    public User login(User user,HttpSession session){
         user1 = userServer.getUserByNameAndPWD(user);

        if(user1!=null){
            user1.setCode(1);
            session.setAttribute("user",user1);
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("denglu","123");
            Subject subject = SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);
            if(subject.isAuthenticated()){
                user.setCode(1);
                return user;
            }
        }
        return null;
    }
    @RequestMapping("/mymain")
    @ResponseBody
    public  List<Site> mymain(String page){
        Integer uid = user1.getId();
        List<Site> site = orderService.getOrder(uid);
        return site;
    }
    @RequestMapping("/register")
    @ResponseBody
    public User register(User user){
        User userByNameAndPWD = userServer.getUserByNameAndPWD(user);
        if(userByNameAndPWD==null){
            Integer register = userServer.register(user);
            user.setCode(1);
            return user;
        }
        return null;
    }
    @RequestMapping("/total")
    @ResponseBody
    public Order test(Integer getid, Integer cid, Integer backid, Double oprice){
        Order order = new Order();
        order.setBackid(backid);
        order.setCid(cid);
        order.setGetid(getid);
        order.setOprice(oprice);
        order.setStatus("已预定");
        order.setUid(user1.getId());
        orderService.addOrder(order);
        return order;
    }
    @RequestMapping("/delete")
    public  String delete(Integer id){
       Integer integer = orderService.deleteById(id);
        return "/mymain/mymain";
    }


    @RequestMapping("/update")
    @ResponseBody
    public  User update(User user){
        return user1;

    }



    @RequestMapping("/loginOut")
    public  String loginOut(User user){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/pagehome/login";

    }
    @RequestMapping("/updateTel")
    @ResponseBody
    public  User  updateTel(User user){
        User userByTel = userServer.getUserByTel(user.getTel());
        if(userByTel==null){
            Integer integer = userServer.updateTcl(user.getTel(), user1.getId());
            user1.setTel(user.getTel());
            user1.setCode(1);
            return user1;
        }
        return null;

    }

}
