package com.jim.ssr.entity.vo;

import com.jim.ssr.entity.OrderDetail;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author Jim
 * @Description 订单入库
 * @createTime 2024年03月27日
 */
@Data
@ToString
public class OrderVO {
    private Integer id;
    private String menuInfo;
    private Integer num;
    private Integer status;
    private Integer price;
    private String createDate;
    private String comment;

    List<OrderDetail> orderList;

}
