package com.jim.ssr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jim.ssr.entity.Type;
import com.jim.ssr.service.TypeService;
import com.jim.ssr.mapper.TypeMapper;
import org.springframework.stereotype.Service;

/**
* @author Jimkk
* @description 针对表【type(分类)】的数据库操作Service实现
* @createDate 2024-03-19 16:20:12
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

}




