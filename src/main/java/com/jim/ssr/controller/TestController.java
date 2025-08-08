package com.jim.ssr.controller;


import com.jim.ssr.SsrApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/local")
    public String local() throws UnsupportedEncodingException {
        String jarPath = SsrApplication.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath();

// 处理路径中的特殊字符（如空格会被编码为%20）
        jarPath = URLDecoder.decode(jarPath, "UTF-8");

// 在Windows上移除开头的"/"
        if (System.getProperty("os.name").toLowerCase().contains("win") && jarPath.startsWith("/")) {
            jarPath = jarPath.substring(1);
        }

        System.out.println("JAR路径: " + jarPath);
        return "local";
    }

}
