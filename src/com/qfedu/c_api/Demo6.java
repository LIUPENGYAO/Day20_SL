package com.qfedu.c_api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo6 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);

        System.out.println(year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + sec);

        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String format1 = format.format(date);
        System.out.println(format1);
    }
}

