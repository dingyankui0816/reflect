package com.cn.reflect.model;

import com.cn.reflect.annotation.DykBean;
import com.cn.reflect.annotation.DykFieldValue;

@DykBean
public class AnnotationBean {
    @DykFieldValue("name")
    private String name;
    @DykFieldValue("description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AnnotationBean{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
