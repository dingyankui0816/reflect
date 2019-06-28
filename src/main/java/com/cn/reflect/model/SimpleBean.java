package com.cn.reflect.model;

public class SimpleBean {
    private String name;
    private Integer age;

    public SimpleBean() {
    }
    private SimpleBean(String name){
        this.name = name;
    }

    public SimpleBean(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public static String abc(){
        return "abc";
    }

    public void aaa(){
        System.out.println("aaa");
    }

    private void bbb(){
        System.out.println("bbb");
    }

    void ccc(){
        System.out.println("ccc");
    }

    private Integer fff(Integer abc,String name){
        System.out.println(name);
        return abc+1;
    }

    protected  void ddd(){
        System.out.println("ddd");
    }

    public static void ggg(){
        System.out.println("静态方法");
    }

    public void eee(String str){
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
