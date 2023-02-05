package com.example.aop.aspect;

import com.example.aop.ReflectionUtil;
import com.example.aop.annotation.Fire;
import com.example.aop.annotation.NeedToken;
import org.apache.logging.log4j.message.Message;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

/**
 * @author Lhz
 */
@Component
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.example.aop.controller.*.*(..))")
    private void checkToken(){};

    @Pointcut("@annotation(com.example.aop.annotation.Fire)")
    private void fireMethod(){};

    @Before("checkToken()")
    private void needToken(JoinPoint joinPoint) throws ClassNotFoundException {
        Object target = joinPoint.getTarget();

        List<Method> methods = ReflectionUtil.getMethodAnnotation(target.getClass(), NeedToken.class);
        for(Method method : methods){
            if(method.getName().equals(joinPoint.getSignature().getName())){
                System.out.println("需要Token");
                return;
            }
        }

        System.out.println("不需要Token");
    }

    @Before("fireMethod()")
    private void v(JoinPoint joinPoint) throws ClassNotFoundException {
        Object[] args = joinPoint.getArgs();

        //获取增强方法的所有参数
        for (Object arg : args) {
            if(arg instanceof String){
                //判断token
                if(!"realToken".equals(arg)) {
                    System.out.println("无效token");
                }
            }
        }

        //获取含有该增强方法的类
        Object targetObject = joinPoint.getTarget();

        //获取该类中所有被Fire注解的方法
        List<Method> methods = ReflectionUtil.getMethodAnnotation(targetObject.getClass(), Fire.class);

        for (Method method : methods) {
            if(!method.getName().equals(joinPoint.getSignature().getName())){
                //过滤掉本方法之外的其他方法
                continue;
            }
            //获取注解中的值
            Fire fire = method.getAnnotation(Fire.class);
            String fireName = fire.fireName();
            int fireCount = fire.fireCount();
            System.out.println(fireCount);
            System.out.printf(fireName);
        }

    }
}
