package com.jim.ssr.mapper;

import com.jim.ssr.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Jimkk
* @description 针对表【tbl_menu(菜单)】的数据库操作Mapper
* @createDate 2024-03-19 17:16:24
* @Entity com.jim.ssr.entity.Menu
*/
@Mapper
public interface MenuMapper {


    /* -------- Generate ----------------- */

    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

}
