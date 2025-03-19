package com.jim.ssr.controller;

import com.jim.ssr.entity.Order;
import com.jim.ssr.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jim
 * @Description 测试
 * @createTime 2024年03月19日
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    OrderMapper om;


    @GetMapping("/hello")
    public String test(){
        return "Hello World";
    }

    @GetMapping("/insert")
    public int post() {
        Order order = new Order();
        order.setMenu_info("面条(18)+煎蛋(2)+加面(2)");
        order.setNum(0);
        order.setStatus(0);
        order.setPrice(22);
        order.setCreateDate("20240319");
        order.setComment("这是一条测试数据");
        return om.insert(order);
    }
}
