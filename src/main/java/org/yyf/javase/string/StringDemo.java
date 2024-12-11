package org.yyf.javase.string;

import com.google.common.base.Throwables;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by @author yyf on 2019-05-23.
 */
public class StringDemo {
    public static void main(String[] args) {
        RuntimeException e = new RuntimeException("hahhahaaahhhhhxxxxxxxxxxxxxxxxxxhahhahaaahhhhhxxxxxxxxxxxxxxxxxxhahhahaaahhhhhxxxxxxxxxxxxxxxxxxhahhahaaahhhhhxxxxxxxxxxxxxxxxxxhahhahaaahhhhhxxxxxxxxxxxxxxxxxx");
        String s = StringUtils.abbreviate(Throwables.getStackTraceAsString(e), 100);
        System.out.println(s);
        int length = "[loan:823267, lpay:40241952,error:java.lang.IllegalArgumentException: lpayDueD Fri Apr 19 00:00:0...".length();
        System.out.println(length);
    }


}
