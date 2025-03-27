package com.jim.ssr.service;


import com.jim.ssr.entity.vo.OrderVO;

/**
* @author Jimkk
* @description 针对表【order(订单)】的数据库操作Service
* @createDate 2024-03-19 16:20:12
*/
public interface OrderService {

    boolean newOrder(OrderVO vo);
}
