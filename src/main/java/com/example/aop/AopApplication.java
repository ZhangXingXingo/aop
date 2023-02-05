package com.example.aop;

import com.example.aop.bean.Apple;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) throws ClassNotFoundException {
        Field[] declaredFields = ReflectionUtil.getDeclaredFields(Apple.class);
        for(Field field : declaredFields){
            System.out.println(field);
        }
        System.out.println("------------------------------------------------------------------");
        Field[] fields = ReflectionUtil.getFields(Apple.class);
        for(Field field : fields){
            System.out.println(field);
        }
        System.out.println("------------------------------------------------------------------");
        Method[] methods = ReflectionUtil.getMethods(Apple.class);
        for(Method method : methods){
            System.out.println(method);
        }
        System.out.println("------------------------------------------------------------------");
        Method[] declaredMethods = ReflectionUtil.getDeclaredMethods(Apple.class);
        for(Method method : declaredMethods){
            System.out.println(method);
        }
        System.err.println("------------------------------------------------------------------");
        SpringApplication.run(AopApplication.class, args);
    }

}
