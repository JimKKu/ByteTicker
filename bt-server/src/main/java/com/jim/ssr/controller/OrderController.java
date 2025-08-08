package com.jim.ssr.controller;


import com.jim.ssr.entity.Order;
import com.jim.ssr.entity.vo.OrderVO;
import com.jim.ssr.mapper.OrderDetailMapper;
import com.jim.ssr.mapper.OrderMapper;
import com.jim.ssr.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService os;

    @PostMapping("/new")
    public String newOrder(@RequestBody OrderVO vo) {
        return os.newOrder(vo)?"000":"999";
    }


    @GetMapping("/history/{date}")
    public List<Order> history(@PathVariable("date") String date, @Param("orderNo") Integer orderNo) {
        return os.history(date,orderNo);
    }

    @GetMapping("/reprint")
    public String rePrint() {
        return os.rePrint();
    }

}
