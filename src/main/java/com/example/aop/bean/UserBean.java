package com.example.aop.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserBean implements Serializable {

    private static final long serialVersionUID = -8715261761026526566L;
    private int id;
    public String name;

}
