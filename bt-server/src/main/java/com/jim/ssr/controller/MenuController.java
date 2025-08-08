package com.jim.ssr.controller;


import com.jim.ssr.entity.Menu;
import com.jim.ssr.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuMapper mm;


    @GetMapping("/list/{typeId}")
    public List<Menu> list(@PathVariable("typeId") Integer typeId) {
        return mm.getMenuList(typeId);
    }

}
