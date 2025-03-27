package com.jim.ssr.controller;
import com.jim.ssr.entity.OrderDetail;

import com.jim.ssr.entity.Order;
import com.jim.ssr.entity.dto.OrderDTO;
import com.jim.ssr.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    OrderMapper om;

    @GetMapping("/1")
    public int test1(){

        List<OrderDetail> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            OrderDetail od = new OrderDetail();
            od.setName1("123");
            od.setName2("123");
            od.setPrice(1);
            od.setSize(1);
            od.setNum(1);
            od.setComment("xxxx");
            list.add(od);
        }

        OrderDTO dto = new OrderDTO();
//        dto.setId(1L);
        dto.setMenuInfo("123");
        dto.setNum(123);
        dto.setStatus(123);
        dto.setPrice(123);
        dto.setCreateDate("xxx");
        dto.setComment("xxx");
        dto.setOrderList(list);

        System.out.println(dto);

        return om.newOrder(dto);
    }
}
