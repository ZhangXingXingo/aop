package com.example.aop.controller;

import com.example.aop.annotation.Fire;
import com.example.aop.bean.Apple;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lhz
 */
@RestController
public class FruitsController2 {

    @Fire(fireName = "aaaaa", fireCount = 6666)
    @PostMapping("/p")
    public String f(@RequestBody Apple apple, @RequestHeader("token") String token){
        System.out.println(apple);
        System.out.println(token);
        return "asd";
    }
    @Fire(fireName = "eeeee", fireCount = 9999)
    @PostMapping("/ap")
    public String fs(@RequestBody Apple apple, @RequestHeader("token") String token){
        System.out.println(apple);
        System.out.println(token);
        return "asd";
    }
}
