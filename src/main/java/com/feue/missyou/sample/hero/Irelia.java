package com.feue.missyou.sample.hero;

import com.feue.missyou.sample.ISkill;
import org.springframework.stereotype.Component;

/**
 * @author Feue
 * @create 2021-06-20 16:20
 */
//@Component
public class Irelia implements ISkill {
    private String name;
    private Integer age;

    public Irelia() {
        System.out.println("Irelia()");
    }

    public Irelia(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void q() {
        System.out.println("Irelia Q");
    }

    @Override
    public void w() {
        System.out.println("Irelia W");
    }

    @Override
    public void e() {
        System.out.println("Irelia E");
    }

    @Override
    public void r() {
        System.out.println("Irelia R");
    }

    @Override
    public String toString() {
        return "Irelia{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
