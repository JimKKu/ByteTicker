package com.jim.ssr.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 订单
 * @TableName order
 */
@Data
public class Order implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 名字1(18.8)+名字2(21.4)+....
     */
    private String menu_info;

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

    private static final long serialVersionUID = 1L;
}