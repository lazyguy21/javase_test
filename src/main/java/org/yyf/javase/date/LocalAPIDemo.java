package org.yyf.javase.date;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * Created by tobi on 2017/7/21.
 */
public class LocalAPIDemo {
  @Test
  public void test() {
    //LocalDateTime-->java.util.date
    LocalDate localDate = LocalDate.now();
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println(localDate);
    System.out.println(localDateTime);
    System.out.println(ZoneId.systemDefault());
    //只有给LocalDateTime加上时区之后，转换成了ZonedDateTime，才能转换成Instant
    //因为LocalDateTime是个相对的时间概念，只有加上时区后才能准确表示一个绝对时间
    Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    Date date = Date.from(instant);
  }

  /**
   * localDateTime和Instant的转换主要就是加上时区和减去时区
   * @throws Exception
   */
  @Test
  public void fromInstant() throws Exception {
    Instant now = Instant.now();
    LocalDateTime localDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
    Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
  }
}
