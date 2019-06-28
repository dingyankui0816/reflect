package com.cn.reflect.model;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class XYZ {
    public static String name = "ding";
    private String xyz;
    private Integer age;

    public XYZ(String xyz, Integer age) {
        this.xyz = xyz;
        this.age = age;
    }

    public String getXyz() {
        return xyz;
    }

    public void setXyz(String xyz) {
        this.xyz = xyz;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    static {
        System.out.println("xyz 静态代码块");
    }

    public XYZ(){
        System.out.println("xyz构造了");
    }
}
class TestMain{
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException {
//        XYZ xyz = new XYZ("abc",11);
//        Class clazz1 = xyz.getClass();
//        Field[] fields =clazz1.getFields();
//        Field[] fields1 = clazz1.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println(field.getName());
//        }
//        for (Field field : fields1) {
//            String key = field.getName();
//            PropertyDescriptor descriptor = new PropertyDescriptor(key,clazz1);
//            Method method = descriptor.getReadMethod();
//            Object value = method.invoke(xyz);
//            System.out.println(key + ":" +value);
//        }
//        Method[] methods = clazz1.getMethods();
//        for (Method method : methods) {
//            System.out.println(method.getName());
//        }

//       Integer integer1 = new Integer(1);
//       Integer integer2 = new Integer(2);
//        System.out.println(integer1.getClass()==integer2.getClass());
        Class clazz = ArrayList.class;
        System.out.println("类名(包括包名) : " + clazz.getName()+"类名（不包括包名） : "+clazz.getSimpleName());
        System.out.println("父类名(包括包名) "+clazz.getSuperclass().getName());
        Class[] interfaces = clazz.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println("获取接口名称 : "+anInterface.getName());
        }

    }
}
