package com.jim.ssr.mapper;

import com.jim.ssr.entity.Type;

/**
* @author Jimkk
* @description 针对表【type(分类)】的数据库操作Mapper
* @createDate 2024-03-19 16:20:54
* @Entity com.jim.ssr.entity.Type
*/
public interface TypeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

}
