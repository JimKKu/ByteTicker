package com.jim.ssr.mapper;

import com.jim.ssr.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Jimkk
* @description 针对表【tbl_type(分类)】的数据库操作Mapper
* @createDate 2024-03-19 17:16:24
* @Entity com.jim.ssr.entity.Type
*/
@Mapper
public interface TypeMapper {


    List<Type> getTypeList();


    /* -------- Generate ----------------- */

    int deleteByPrimaryKey(Long id);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

}
