package com.qf.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.qf.realm.ShiroRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    public CookieRememberMeManager createCookieRememberMeManager(){
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName("rememberMe");
        simpleCookie.setMaxAge(5000);
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(simpleCookie);
        return cookieRememberMeManager;
    }

    @Bean
    public ShiroDialect createShiroDialect(){

        return new ShiroDialect();
    }
    @Bean
    public ShiroFilterFactoryBean createShiroFilterFactoryBean(){
     ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
     shiroFilterFactoryBean.setSecurityManager(createSecurityManager());
        //未认证跳转登录页面
        shiroFilterFactoryBean.setLoginUrl("/user/toLogin");
        //设置未授权跳转页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/error");
        //有顺序的map集合

        Map<String,String> linkedHashMap  = new LinkedHashMap<>();
        linkedHashMap.put("/js/**","anon");
        linkedHashMap.put("/css/**","anon");


        linkedHashMap.put("/user/login","anon");

        linkedHashMap.put("/user/index","user");
        //需要认证才能访问

        //配置授权过滤器，设置未授权访问URL
        linkedHashMap.put("/user/add","perms[user:add]");
        linkedHashMap.put("/user/select","perms[user:select]");

        linkedHashMap.put("/user/logout","logout");
        linkedHashMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(linkedHashMap);


        return shiroFilterFactoryBean;
    }
    @Bean
    public DefaultWebSecurityManager createSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(createShiroRealm());
        securityManager.setRememberMeManager(createCookieRememberMeManager());
        return securityManager;
}

    @Bean
    public ShiroRealm createShiroRealm(){
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }
}
