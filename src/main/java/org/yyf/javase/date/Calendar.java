package org.yyf.javase.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by tobi on 2017/6/19.
 */
public class Calendar {
  public static void main(String[] args) {
    LocalDate date = LocalDate.now();
    date = date.minusMonths(1);
    System.out.println(date.getYear());
    System.out.println(date);

    java.util.Calendar currentCalendar = java.util.Calendar.getInstance();
    System.out.println(currentCalendar);

//    LocalDate now = LocalDate.now();
    LocalDate now = LocalDate.of(2017, 1, 2);
    LocalDate lastMonth = now.minusMonths(1);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
    String lastMonthStr = formatter.format(lastMonth);
    System.out.println(lastMonthStr);






  }
}
