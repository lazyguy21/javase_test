package org.yyf.javase.date;

import org.junit.Test;

import java.util.Date;
import java.util.TimeZone;

/**
 * Created by tobi on 2017/7/21.
 */
public class DateDemo {
  /**
   * java.util.date本身是没有存储时区概念的，其存的是UTC标准毫秒，
   * 只不过toString的时候会去获得默认的时区，然后转换成默认时区的时间
   * 所以在这个例子里面，将默认的上海时区改为UTC后，系统就将时间减了8小时。
   * 系统认为我在英格兰的格林威治……
   */
  @Test
  public void t(){
    Date date = new Date();
    String s = date.toString();
    System.out.println(s);
    System.out.println(TimeZone.getDefault());
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    System.out.println(date.toString());

  }
}
