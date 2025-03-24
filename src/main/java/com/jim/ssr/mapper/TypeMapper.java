package com.jim.ssr.mapper;


import com.jim.ssr.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {

    List<Type> getTypeList();


}
