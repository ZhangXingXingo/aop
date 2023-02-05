package com.example.aop;

import com.example.aop.annotation.Fire;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Lhz
 */
public class ReflectionUtil {
    /**
     * 创建类的实例
     */
    public static Object newObject(Class<?> object) throws ClassNotFoundException{
        // 1.获取类的包路径
        String name = object.getName();
        System.err.println("name : " + name);
        // 2.通过反射创建类的实例
        Class<?> clazz = Class.forName(name);
        System.err.println("new Class : " + clazz);
        Object newObject = null;
        try {
            newObject = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return newObject;
    }

    /**
     * 获得类中属性
     * getField(String name)	获得某个公有的属性对象
     * getFields()	获得所有公有的属性对象
     * getDeclaredField(String name)	获得某个属性对象
     * getDeclaredFields()	获得所有属性对象
     */
    public static Field[] getFields(Class<?> object) throws ClassNotFoundException {
        String name = object.getName();
        Class<?> clazz = Class.forName(name);
        return clazz.getFields();
    }
    public static Field[] getDeclaredFields(Class<?> object) throws ClassNotFoundException {
        String name = object.getName();
        Class<?> clazz = Class.forName(name);
        return clazz.getDeclaredFields();
    }

    /**
     * getMethod(String name, Class...<?> parameterTypes)	获得该类某个公有的方法
     * getMethods()	获得该类所有公有的方法
     * getDeclaredMethod(String name, Class...<?> parameterTypes)	获得该类某个方法
     * getDeclaredMethods()	获得该类所有方法
     */
    public static Method[] getMethods(Class<?> object) throws ClassNotFoundException{
        String name = object.getName();
        Class<?> clazz = Class.forName(name);
        return  clazz.getMethods();
    }
    public static Method[] getDeclaredMethods(Class<?> object) throws ClassNotFoundException{
        String name = object.getName();
        Class<?> clazz = Class.forName(name);
        return  clazz.getDeclaredMethods();
    }

    /**
     * getAnnotation(Class<A> annotationClass)	返回该类中与参数类型匹配的公有注解对象
     * getAnnotations()	返回该类所有的公有注解对象
     * getDeclaredAnnotation(Class<A> annotationClass)	返回该类中与参数类型匹配的所有注解对象
     * getDeclaredAnnotations()	返回该类所有的注解对象
     * 获取类上注解
     */
    public static Object getFireAnnotation(Class<?> object) throws ClassNotFoundException{
        String name = object.getName();
        Class<?> clazz = Class.forName(name);
        Fire annotation = clazz.getAnnotation(Fire.class);
        if(Objects.nonNull(annotation)){
            return annotation;
        }
        return null;
    }
    /**
     * 获取该类中标MethodAnnotation注解的方法
     */
    public static List<Method> getMethodAnnotation(Class<?> object, Class<? extends Annotation> annotation) throws ClassNotFoundException {
        Method[] methods = getMethods(object);
        ArrayList<Method> list = new ArrayList<>();

        for (Method method : methods) {
            Annotation methodAnnotation = method.getAnnotation(annotation);
            if (Objects.nonNull(methodAnnotation)) {
                list.add(method);
            }
        }
        return list;
    }
}
