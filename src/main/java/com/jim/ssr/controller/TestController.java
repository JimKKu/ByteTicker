package com.jim.ssr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jim
 * @Description 测试
 * @createTime 2024年03月19日
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String test(){
        return "Hello World";
    }

}
