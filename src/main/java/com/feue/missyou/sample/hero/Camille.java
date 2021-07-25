package com.feue.missyou.sample.hero;

import com.feue.missyou.sample.ISkill;

/**
 * @author Feue
 * @create 2021-06-20 18:18
 */
public class Camille implements ISkill {
    private String name;
    private Integer age;

    public Camille() {
        System.out.println("Camille");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Camille(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void q() {
        System.out.println("Camille Q");
    }

    @Override
    public void w() {
        System.out.println("Camille W");
    }

    @Override
    public void e() {
        System.out.println("Camille E");
    }

    @Override
    public void r() {
        System.out.println("Camille R");
    }

    @Override
    public String toString() {
        return "Camille{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
