package com.qf.mapper;

import com.qf.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderMapper {
    public List<Order> getOrder(Integer uid);

}
