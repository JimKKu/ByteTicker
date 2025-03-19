package com.jim.ssr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jim.ssr.entity.Order;
import com.jim.ssr.service.OrderService;
import com.jim.ssr.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author Jimkk
* @description 针对表【order(订单)】的数据库操作Service实现
* @createDate 2024-03-19 16:20:12
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




