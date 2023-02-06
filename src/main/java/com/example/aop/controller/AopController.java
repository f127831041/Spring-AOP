package com.example.aop.controller;

import com.example.aop.annotation.Add;
import com.example.aop.annotation.Delete;
import com.example.aop.annotation.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author viper
 * @Date 2023/2/6 上午 10:35
 * @Version 1.0
 */
@RestController
public class AopController {
    
    @Add
    @GetMapping("/add")
    public void add() {
        System.out.println("add OK");
    }
    
    @Update
    @GetMapping("/update")
    public void update() {
        System.out.println("update OK");
    }
    
    @Delete
    @GetMapping("/delete")
    public void delete() {
        System.out.println("delete OK");
    }
    
}
