package com.example.aop.controller;

import com.example.aop.annotation.Fire;
import com.example.aop.annotation.NeedToken;
import com.example.aop.bean.Apple;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lhz
 */
@RestController
public class FruitsController {

    @Fire(fireName = "aaaaa", fireCount = 6666)
    @NeedToken
    @PostMapping("/")
    public String f(@RequestBody Apple apple, @RequestHeader("token") String token){
        System.out.println(apple);
        System.out.println(token);
        return "asd";
    }

    @Fire(fireName = "eeeee", fireCount = 9999)
    @PostMapping("/a")
    public String fs(@RequestBody Apple apple, @RequestHeader("token") String token){
        System.out.println(apple);
        System.out.println(token);
        return "asd";
    }
}
