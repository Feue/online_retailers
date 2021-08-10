package com.feue.missyou.util;

import com.feue.missyou.bo.PageCounter;

import java.util.Date;

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

    public static Boolean isInTimeLine(Date date, Date start, Date end) {
        Long time = date.getTime();
        Long startTime = start.getTime();
        Long endTime = end.getTime();
        if (time >= startTime && time <= endTime) {
            return true;
        }
        return false;
    }
}
