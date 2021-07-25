package com.feue.missyou.sample.hero;

import com.feue.missyou.sample.ISkill;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author Feue
 * @create 2021-06-18 9:16
 */
//@Component
//@Lazy
//@Primary
public class Diana implements ISkill {
    private String name;
    private Integer age;

    public Diana(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Diana() {
        System.out.println("Diana()");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void q() {
        System.out.println("Diana Q");
    }

    @Override
    public void w() {
        System.out.println("Diana W");
    }

    @Override
    public void e() {
        System.out.println("Diana E");
    }

    @Override
    public void r() {
        System.out.println("Diana R");
    }

    @Override
    public String toString() {
        return "Diana{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
