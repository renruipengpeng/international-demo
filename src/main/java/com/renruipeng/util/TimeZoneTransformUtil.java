package com.renruipeng.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Mr--renruipeng
 * @date 2020-01-09
 **/
public class TimeZoneTransformUtil {


    private static String dateTransformBetweenTimeZone(Date sourceDate, DateFormat formatter,
                                                       TimeZone sourceTimeZone, TimeZone targetTimeZone) {
        Long targetTime = sourceDate.getTime() - sourceTimeZone.getRawOffset() + targetTimeZone.getRawOffset();

        return getTime(new Date(targetTime), formatter);
    }

    private static String getTime(Date date, DateFormat formatter) {

        return formatter.format(date);

    }

    private static String getTimeZone() {

        Calendar cal = Calendar.getInstance();

        int timeZone = cal.getTimeZone().getOffset(System.currentTimeMillis()) / (3600000);

        if (timeZone >= 0) {
            return String.valueOf("+" + timeZone);
        }

        return String.valueOf(timeZone);
    }

    /**
     *
     * @param date  ---需要转换的时间
     * @param targetTimeZone  ---目标时区 如 GMT+1 GMT+2等
     * @param formatter  ---转换后返回的时间格式
     * @return
     */
    public static String getGMTTime(Date date, String targetTimeZone,SimpleDateFormat formatter) {

        TimeZone srcTimeZone = TimeZone.getTimeZone("GMT+8" + getTimeZone());

        TimeZone destTimeZone = TimeZone.getTimeZone(targetTimeZone);

        return dateTransformBetweenTimeZone(date, formatter, srcTimeZone, destTimeZone);

    }

}

