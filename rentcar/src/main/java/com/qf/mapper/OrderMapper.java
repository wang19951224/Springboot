package com.qf.mapper;

import com.qf.entity.Order;
import com.qf.entity.Site;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderMapper {
    public List<Site> getOrder(Integer uid);
    public Integer addOrder(Order order);
    public Integer deleteById(Integer id);

}
