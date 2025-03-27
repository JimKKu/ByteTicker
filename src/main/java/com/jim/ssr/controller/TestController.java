package com.jim.ssr.controller;

import com.jim.ssr.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jim
 * @Description
 * @createTime 2024年03月27日
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/1")
    public int test1(){
        List<Order> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            Order order = new Order();
            order.setMenu_info("测试");
            order.setNum(i);
            order.setStatus(i);
            order.setPrice(i);
            order.setCreateDate("20240327");
            order.setComment("备注备注");
        }
        return 1;
    }
}
