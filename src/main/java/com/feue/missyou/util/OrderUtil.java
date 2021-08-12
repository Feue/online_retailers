package com.feue.missyou.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Locale;

/**
 * @author Feue
 * @create 2021-08-12 10:23
 */
@Component
public class OrderUtil {

    private static String[] yearCodes;

    @Value("${missyou.year-codes}")
    public void setYearCodes(String yearCodes) {
        OrderUtil.yearCodes = yearCodes.split(",");
    }

    public static String makeOrderNo() {
        StringBuffer joiner = new StringBuffer();
        Calendar calendar = Calendar.getInstance();
        String mills = String.valueOf(calendar.getTimeInMillis());
        String micro = LocalDateTime.now().toString();
        String random = String.valueOf(Math.random()*1000).substring(0, 2);
        joiner.append(OrderUtil.yearCodes[calendar.get(Calendar.YEAR)-2021])
                .append(Integer.toHexString(calendar.get(Calendar.MONTH)+1).toUpperCase())
                .append(calendar.get(Calendar.DAY_OF_MONTH))
                .append(mills.substring(mills.length()-5))
                .append(micro.substring(micro.length()-3))
                .append(random);
        return joiner.toString();
    }
}
