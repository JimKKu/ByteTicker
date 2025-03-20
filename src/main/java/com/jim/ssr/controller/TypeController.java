package com.jim.ssr.controller;

import com.jim.ssr.entity.Type;
import com.jim.ssr.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jim
 * @Description 分类
 * @createTime 2024年03月20日
 */

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    TypeMapper tm;

    @GetMapping("/list")
    public List<Type> list() {
        return tm.getTypeList();
    }
}
