package com.jim.ssr.service.impl;


import com.jim.ssr.entity.Order;
import com.jim.ssr.entity.OrderDetail;
import com.jim.ssr.entity.vo.OrderVO;
import com.jim.ssr.mapper.OrderDetailMapper;
import com.jim.ssr.mapper.OrderMapper;
import com.jim.ssr.service.OrderService;
import com.jim.ssr.utils.PrinterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
* @author Jimkk
* @description 针对表【order(订单)】的数据库操作Service实现
* @createDate 2024-03-19 16:20:12
*/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper om;
    @Autowired
    OrderDetailMapper odm;


    @Override
    public boolean newOrder(OrderVO vo) {
        /* - 修正参数 - */
        // 总价
        int price = 0;
        StringBuilder sb = new StringBuilder();
        for (OrderDetail detail : vo.getOrderList()) {
            price += detail.getPrice();
            sb.append(detail.getName1()+(detail.getName2()==null?"":"-"+detail.getName2())+(detail.getSize() == 1?"(小)":detail.getNum() == 2?"(大)":"")+"*"+detail.getNum()+"/");
        }
        sb.delete(sb.length()-1,sb.length());
        vo.setPrice(price);
        vo.setMenuInfo(String.valueOf(sb));
        // 订单号码
        vo.setNum(buildNum());
        /* - 入库 ---- */
        int iom = om.newOrder(vo);
        int idm = odm.newOrder(vo.getOrderList(),vo.getId());

        PrinterUtils.print(vo);
        // --- 表单号码
        /* - 打印小票 - */
        return iom>0 && idm > 0;
    }

    @Override
    public List<Order> history(String date,Integer orderNo) {
        return om.historyOrder(date,orderNo);
    }


    private int buildNum(){
        /*-- 创建表单号码 --*/
        Integer num = om.selectMaxNum();
        // 获取时间
        if(num == null) {
            return 10000;
        }
        return ++num;
    }

}




