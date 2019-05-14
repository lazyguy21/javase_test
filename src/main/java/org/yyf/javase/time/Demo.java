package org.yyf.javase.time;

import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by @author yyf on 2019-04-27.
 */
public class Demo {
    public static void main(String[] args) {
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        dateTimeFormatter.parse("1990-12-12 13:12:12");
//        String s = dateTimeFormatter.format(new Date().toInstant());
//        System.out.println(s);

        Date date = new Date(2019, 12, 21, 2, 30, 23);
        System.out.println(date);
    }
}
