package com.qf.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/toLogin")
    public String tologin(){
        return "login";
    }
    @RequestMapping("/error")
    public  String error(){
        return "error";
    }


    @RequestMapping("/login")
    public  String login(String name, String password, Model model,boolean rememberMe){
        Subject subject = SecurityUtils.getSubject();
        System.out.println(rememberMe);
        UsernamePasswordToken token = new UsernamePasswordToken(name, password,rememberMe);
        try {
            subject.login(token);
            return "index";
        } catch (AuthenticationException e) {
            model.addAttribute("msg","账户名或密码错误");
            return "login";
        }
    }

    @RequestMapping("/index")
    public  String index(){
        return "index";
    }
    @RequestMapping("/add")
    public  String add(){
        return "add";
    }
    @RequestMapping("/select")
    public  String select(){
        return "select";
    }
    @RequestMapping("/delete")
    public  String delete(){
        return "delete";
    }
    @RequestMapping("/update")
    public  String update(){
        return "update";
    }
    @RequestMapping("/logout")
    public String logout(){

        Subject subject = SecurityUtils.getSubject();

        subject.logout();

        return "toLogin";
    }


}
