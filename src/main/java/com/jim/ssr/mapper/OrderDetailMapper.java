package com.jim.ssr.mapper;

import com.jim.ssr.entity.OrderDetail;

/**
* @author Jimkk
* @description 针对表【tbl_order_detail(订单信息)】的数据库操作Mapper
* @createDate 2024-03-27 14:39:24
* @Entity com.jim.ssr.entity.OrderDetail
*/
public interface OrderDetailMapper {

    int deleteByPrimaryKey(Long id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

}
