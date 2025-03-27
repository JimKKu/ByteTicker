package com.jim.ssr.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * 订单
 * @TableName tbl_order
 */
@Data
@ToString
public class Order {
    /**
     * 逐渐
     */
    private Long id;

    /**
     * 名字1(18.8)+名字2(21.4)+....
     */
    private String menuInfo;

    /**
     * 订单号码（出现在小票上的），0~999
     */
    private Integer num;

    /**
     * 0 创建 1 完成 4 删除
     */
    private Integer status;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 创建日期
     */
    private String createDate;

    /**
     * 备注
     */
    private String comment;

}