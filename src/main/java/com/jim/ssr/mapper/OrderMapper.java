package com.jim.ssr.mapper;

import com.jim.ssr.entity.Order;
import com.jim.ssr.entity.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Jimkk
* @description 针对表【tbl_order(订单)】的数据库操作Mapper
* @createDate 2024-03-27 14:39:24
* @Entity com.jim.ssr.entity.Order
*/
@Mapper
public interface OrderMapper {

    int newOrder(OrderVO record);

    Integer selectMaxNum();

    List<Order> historyOrder(@Param("date") String date, @Param("orderNo") Integer orderNo);


    /* ----- Generate ------- */

    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

}
