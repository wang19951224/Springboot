package com.qf.service;

import com.qf.entity.Order;
import com.qf.entity.Site;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderServer {
    public List<Site> getOrder(Integer uid);
    public Integer addOrder(Order order);
    public Integer deleteById(Integer id);
}
