package com.cn.reflect.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectForNameToList {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Class aClass=Class.forName("java.util.ArrayList");
        Method method=aClass.getMethod("add", Object.class);
        method.invoke(list,"aaaa");
        System.out.println(list);
    }
}
