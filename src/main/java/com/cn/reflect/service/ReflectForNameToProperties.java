package com.cn.reflect.service;


import com.cn.reflect.annotation.DykAutowire;
import com.cn.reflect.annotation.DykBean;
import com.cn.reflect.annotation.DykFieldValue;
import com.cn.reflect.model.AnnotationBean;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ReflectForNameToProperties {

    private static Map<String,Object> ioc = new HashMap<>();

    static {
        try {
            Class clazz = Class.forName("com.cn.reflect.model.AnnotationBean");
            if (clazz.isAnnotationPresent(DykBean.class)){
                Object object = clazz.getDeclaredConstructor().newInstance();
                Field[] fields  = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (!field.isAnnotationPresent(DykFieldValue.class)){
                        continue;
                    }
                    String value = field.getAnnotation(DykFieldValue.class).value();
                    field.setAccessible(true);
                    field.set(object,value);
                }
                char[] chars = clazz.getSimpleName().toCharArray();
                chars[0] += 32;
                ioc.put(String.valueOf(chars),object);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @DykAutowire
    private static AnnotationBean annotationBean;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        Class clazz=Class.forName("com.cn.reflect.model.SimpleBean");
        Object object = clazz.getConstructor().newInstance();
        clazz.getMethod("setAge", Integer.class).invoke(object,Integer.valueOf(getTxt("age")));
        clazz.getMethod("setName", String.class).invoke(object,getTxt("name"));
        System.out.println(object.toString());
        System.out.println("===============Annotation================");
        Field[] fields = ReflectForNameToProperties.class.getDeclaredFields();
        Object o = ReflectForNameToProperties.class.getDeclaredConstructor().newInstance();
        for (Field field : fields) {
             if (!field.isAnnotationPresent(DykAutowire.class)){
                 continue;
             }
             String value = field.getAnnotation(DykAutowire.class).value();
             if (value == null||value.equals("")){

                 char[] chars = field.getType().getSimpleName().toCharArray();
                 chars[0] += 32;
                 value = String.valueOf(chars);
             }
            field.set(o,ioc.get(value));
        }
        System.out.println(annotationBean.toString());
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
