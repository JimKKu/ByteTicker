package com.jim.ssr.entity.vo;

import com.jim.ssr.entity.Order;
import com.jim.ssr.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author Jim
 * @Description 订单入库
 * @createTime 2024年03月27日
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO {
    private Integer id;
    private String menuInfo;
    private Integer num;
    private Integer status;
    private Integer price;
    private String createDate;
    private String comment;

    List<OrderDetail> orderList;


    public OrderVO(Order order, List<OrderDetail> details) {
        this.num = order.getNum();
        this.price = order.getPrice();
        this.comment = order.getComment();
        this.orderList = details;
    }

}
