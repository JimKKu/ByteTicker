package com.jim.ssr.service;


import com.jim.ssr.entity.Order;
import com.jim.ssr.entity.vo.OrderVO;

import java.util.List;

/**
* @author Jimkk
* @description 针对表【order(订单)】的数据库操作Service
* @createDate 2024-03-19 16:20:12
*/
public interface OrderService {

    boolean newOrder(OrderVO vo);

    List<Order> history(String date, Integer orderNo);

    String rePrint();
}
