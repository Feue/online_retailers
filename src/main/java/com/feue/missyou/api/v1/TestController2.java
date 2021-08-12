package com.feue.missyou.api.v1;

import com.feue.missyou.sample.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Feue
 * @create 2021-08-10 12:54
 */
@RestController
@RequestMapping("/test")
public class TestController2 {
    @Autowired
    private Test test;
    @Autowired
    private Test test2;

    @GetMapping
    public void getDetail() {
        System.out.println(this.test);
        System.out.println(this.test2);
    }
}
