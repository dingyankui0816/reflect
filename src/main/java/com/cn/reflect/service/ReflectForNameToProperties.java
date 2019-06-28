package com.cn.reflect.service;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class ReflectForNameToProperties {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        Class clazz=Class.forName("com.cn.reflect.model.SimpleBean");
        Object object = clazz.getConstructor().newInstance();
        clazz.getMethod("setAge", Integer.class).invoke(object,Integer.valueOf(getTxt("age")));
        clazz.getMethod("setName", String.class).invoke(object,getTxt("name"));
        System.out.println(object.toString());
    }

    public static String getTxt(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")
                +"/src/main/java/com/cn/reflect/pro.properties");
        properties.load(fileInputStream);
        try {
            return (String) properties.get(key);
        }finally {
            fileInputStream.close();
        }
    }
}
