package com.feue.missyou.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feue.missyou.exception.http.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Feue
 * @create 2021-07-28 10:41
 *
 * 序列化与反序列化工具类
 */
@Component
public class GenericAndJson {
    private static ObjectMapper mapper;

    @Autowired
    public void setMapper(ObjectMapper mapper) {
        GenericAndJson.mapper = mapper;
    }

    public static <T> String objectToJson(T o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    public static <T> T jsonToObject(String s, TypeReference<T> tr) {
        if (s == null) {
            return null;
        }
        try {
            T o = mapper.readValue(s, tr);
            return o;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

//    // List<T> 整个当作泛型T
//    public static <T> T jsonToList(String s, TypeReference<T> tr) {
//        if (s == null) {
//            return null;
//        }
//        try {
//            T list = mapper.readValue(s, tr);
//            return list;
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            throw new ServerErrorException(9999);
//        }
//    }
//
//    // List<T> 中的T作为泛型
//    // 有问题，无法推断出T的类型，List中的元素自动转化成Map
//    public static <T> List<T> jsonToList(String s) {
//        if (s == null) {
//            return null;
//        }
//        try {
//            List<T> list = mapper.readValue(s, new TypeReference<List<T>>() {
//            });
//            return list;
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            throw new ServerErrorException(9999);
//        }
//    }
}
