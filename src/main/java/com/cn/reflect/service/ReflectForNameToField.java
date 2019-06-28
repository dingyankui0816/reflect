package com.cn.reflect.service;

import com.cn.reflect.model.SimpleBean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectForNameToField {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("com.cn.reflect.model.SimpleBean");
        System.out.println("=============获取所有公有的字段==============");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("===============获取所有的字段================");
        Field[] declaredFields=clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("============获取私有字段,并调用=============");
        Field field = clazz.getDeclaredField("name");
        System.out.println(field);
        Object obj = clazz.getConstructor().newInstance();
        field.setAccessible(true); //暴力访问(忽略掉访问修饰符)
        field.set(obj,"私有字段");
        System.out.println(((SimpleBean)obj).getName());
    }
}
