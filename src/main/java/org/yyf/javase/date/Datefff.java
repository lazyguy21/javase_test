package org.yyf.javase.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by @author yyf on 2018/4/30.
 */
public class Datefff

{
  public static void main(String[] args) throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
    Date d = simpleDateFormat.parse("2018-5-15 12:23:22");
    System.out.println(d.getTime());

    System.out.println(new Date(1526486400000L));
  }
}
