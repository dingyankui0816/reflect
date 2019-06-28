package com.cn.reflect.service;


import java.util.ArrayList;

public class DetailInfo {
    public static void main(String[] args) {
        Class clazz = ArrayList.class;
        System.out.println("类名(包括包名)：" + clazz.getName() + ",类名(不包括包名)：" + clazz.getSimpleName());
        System.out.println("父类名(包括包名)："+clazz.getSuperclass().getName());
        Class[] interfaces =  clazz.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println("获取接口名称 : " + anInterface.getName());
        }
    }
}
