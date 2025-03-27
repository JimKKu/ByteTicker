package com.jim.ssr.controller;
import com.jim.ssr.entity.Order;
import com.jim.ssr.entity.OrderDetail;

import com.jim.ssr.entity.vo.OrderVO;
import com.jim.ssr.mapper.OrderDetailMapper;
import com.jim.ssr.mapper.OrderMapper;
import com.jim.ssr.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Jim
 * @Description
 * @createTime 2024年03月27日
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    OrderMapper om;
    @Autowired
    OrderDetailMapper odm;

    @Autowired
    OrderService os;


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


        return odm.newOrder(list,1);
    }

    @GetMapping("/2")
    public OrderVO test2(){


        OrderVO vo = new OrderVO();
        vo.setMenuInfo("123");
        vo.setNum(123);
        vo.setStatus(123);
        vo.setPrice(123);
        vo.setCreateDate("123xx");
        vo.setComment("123xx");
        om.newOrder(vo);
        return vo;
    }

    @GetMapping("/3")
    public boolean test3(){

        long ttt = 0L;
        for (int j = 0; j < 10000; j++) {
            List<OrderDetail> list = new ArrayList<>();
            for(int i=0;i<10;i++){
                OrderDetail od = new OrderDetail();
                od.setName1("123");
                od.setName2("123");
                od.setPrice(11);
                od.setSize(1);
                od.setNum(1);
                od.setComment("xxxx");
                list.add(od);
            }

            OrderVO vo = new OrderVO();
            vo.setMenuInfo("123");
            vo.setNum(123);
            vo.setStatus(123);
            vo.setPrice(123);
            vo.setCreateDate("123xx");
            vo.setComment("123xx");
            vo.setOrderList(list);
            long t1 = Calendar.getInstance().getTimeInMillis();
            os.newOrder(vo);
            long t2 = Calendar.getInstance().getTimeInMillis();
            log.info("第{}次插入耗时{}毫秒",j,t2-t1);
            ttt += t2-t1;

        }
        log.info("总共耗时{}毫秒,平均每次耗时{}毫秒",ttt,ttt/1000);



//        long t1 = Calendar.getInstance().getTimeInMillis();
//        long t2,t3;
//        for (int i = 0; i < 10000; i++) {
//            t2 = Calendar.getInstance().getTimeInMillis();
//            os.newOrder(vo);
//            t3 = Calendar.getInstance().getTimeInMillis();
////            log.info("第{}次插入耗时{}毫秒",i,t3-t2);
//        }
//        log.info("总共耗时{}毫秒",Calendar.getInstance().getTimeInMillis()-t1);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Calendar.getInstance().getTimeInMillis());
    }
    @GetMapping("/4")
    public Integer test4(){
        return om.selectMaxNum();
    }
}
