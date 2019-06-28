package com.cn.reflect.service;

import com.cn.reflect.model.SimpleBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectForName {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Class.forName("com.cn.reflect.model.SimpleBean");
        System.out.println("=============获取所有公有构造方法==============");
        Constructor[] constructors=clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("=============获取所有构造方法==============");
        Constructor[] declaredConstructors=clazz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        System.out.println("=============获取公有指定的构造方法==========");
        Constructor constructor=clazz.getConstructor(String.class,Integer.class);
        System.out.println(constructor);
        System.out.println("=============获取私有指定的构造方法，并调用==========");
        Constructor privateConstructor=clazz.getDeclaredConstructor(String.class);
        System.out.println(privateConstructor);
        //调用构造方法
        privateConstructor.setAccessible(true); //暴力访问(忽略掉访问修饰符)
        Object obj = privateConstructor.newInstance("abc");
        System.out.println(((SimpleBean)obj).getName());
    }
}
