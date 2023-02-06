package com.example.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author viper
 * @Date 2023/2/6 上午 11:12
 * @Version 1.0
 */
@RestController
public class HomeController {
    
    @GetMapping("/test")
    public void test() {
        System.out.println("TEST TEST TEST");
    }
    
}
