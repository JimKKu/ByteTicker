package com.jim.ssr.mapper;

import com.jim.ssr.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    int insert(Order order);

}
