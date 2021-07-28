package com.feue.missyou.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author Feue
 * @create 2021-07-28 16:51
 */
public class OptionalTest {
    @Test
    public void testOptional() {
        // 构建空Optional对象
        Optional<String> empty = Optional.empty();
//        Optional<String> t1 = Optional.of(null);
        Optional<String> t2 = Optional.ofNullable("a");
//        empty.get();
//        return empty;
//        String s = t2.get();
        t2.ifPresent(System.out::println);

        String s = t2.orElse("default");
        System.out.println(s);

        String s1 = t2.map(t -> t+'b').orElse("default");
        System.out.println(s1);
    }
}
