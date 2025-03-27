package com.jim.ssr.mapper;

import com.jim.ssr.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Jimkk
* @description 针对表【tbl_order_detail(订单信息)】的数据库操作Mapper
* @createDate 2024-03-27 14:39:24
* @Entity com.jim.ssr.entity.OrderDetail
*/
@Mapper
public interface OrderDetailMapper {


    int newOrder(@Param("list")List<OrderDetail> list,@Param("orderId") Integer orderId);

    int deleteByPrimaryKey(Long id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

}
