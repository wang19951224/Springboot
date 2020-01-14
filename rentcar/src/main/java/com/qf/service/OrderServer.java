package com.qf.service;

import com.qf.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderServer {
    public List<Order> getOrder(Integer uid);
}
