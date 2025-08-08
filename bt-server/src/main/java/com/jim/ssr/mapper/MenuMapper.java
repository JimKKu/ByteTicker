package com.jim.ssr.mapper;

import com.jim.ssr.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Jim
* @description 针对表【tbl_menu(菜单)】的数据库操作Mapper
* @createDate 2024-03-24 15:52:16
* @Entity com.jim.ssr.entity.Menu
*/
@Mapper
public interface MenuMapper {



    List<Menu> getMenuList(Integer typeId);


    /* ----------- Generate ----------------------------- */
    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

}
