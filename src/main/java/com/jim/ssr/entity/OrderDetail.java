package com.jim.ssr.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * 订单信息
 * @TableName tbl_order_detail
 */
@Data
@ToString
public class OrderDetail {
    /**
     * ID
     */
    private Long id;

    /**
     * 外键
     */
    private Long order_id;

    /**
     * 主标题
     */
    private String name1;

    /**
     * 副标题
     */
    private String name2;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 大份小份
     */
    private Integer size;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 备注
     */
    private String comment;

}