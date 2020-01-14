package com.qf.service.impl;

import com.qf.entity.Order;
import com.qf.mapper.OrderMapper;
import com.qf.service.OrderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderServer {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> getOrder(Integer uid) {
        return orderMapper.getOrder(uid);
    }
}
