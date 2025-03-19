package com.jim.ssr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jim.ssr.entity.Menu;
import com.jim.ssr.service.MenuService;
import com.jim.ssr.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author Jimkk
* @description 针对表【menu(菜单)】的数据库操作Service实现
* @createDate 2024-03-19 16:20:12
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

}




