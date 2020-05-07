package com.cn.reflect.service;

import com.cn.reflect.model.SimpleBean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectForNameToMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("com.cn.reflect.model.SimpleBean");
        System.out.println("=============获取所有公有方法(包括继承父类的方法)==============");
        Method[] methods =clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("=============获取所有方法(不包括父类的方法)==============");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
        System.out.println("=============获取公有方法，并调用==============");
        Method method=clazz.getMethod("eee", String.class);
        System.out.println(method);
        Object object = clazz.getConstructor().newInstance();
        System.out.println(method.invoke(object,"公有方法"));
        System.out.println("=============获取私有方法，并调用==============");
        Method declaredMethod=clazz.getDeclaredMethod("fff", Integer.class, String.class);
        Object obj = clazz.getConstructor().newInstance();
        declaredMethod.setAccessible(true);
        System.out.println(declaredMethod.invoke(obj,1,"私有方法"));
        System.out.println("=============获取静态方法，并调用==============");
        Method staticMethod = clazz.getMethod("ggg");
        //静态方法可以为null
        staticMethod.invoke(null);
        System.out.println("=============代理模式，并调用==============");
        SimpleBean simpleBean = new SimpleBean("levi.ding",23);
        Method toStringMethod = clazz.getMethod("toString");
        System.out.println(toStringMethod.invoke(simpleBean));
    }
}
