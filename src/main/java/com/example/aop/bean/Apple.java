package com.example.aop.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Lhz
 */
@Data
public class Apple {
    private BigDecimal price;
    public String color;


    private String heihhh(){
        return  "ad";
    }

    public Integer heihhh(int a){
        return  a;
    }

    public String  asd(){
        return  "asd";
    }


}
