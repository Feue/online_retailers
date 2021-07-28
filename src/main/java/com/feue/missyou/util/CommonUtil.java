package com.feue.missyou.util;

import com.feue.missyou.bo.PageCounter;

/**
 * @author Feue
 * @create 2021-07-25 13:18
 */
public class CommonUtil {
    public static PageCounter convertToPageParameter(Integer start, Integer count) {
        int pageNum = start/count;
        return PageCounter.builder()
                .page(pageNum)
                .count(count)
                .build();
    }
}
