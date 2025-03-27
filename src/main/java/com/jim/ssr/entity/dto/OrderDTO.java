package com.jim.ssr.entity.dto;

import lombok.Data;

/**
 * @author Jim
 * @Description 订单入库
 * @createTime 2024年03月27日
 */
@Data
public class OrderDTO {
    private Long id;
    private String menu_info;
    private Integer num;
    private Integer status;
    private Integer price;
    private String createDate;
    private String comment;

}
