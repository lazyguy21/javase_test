package org.yyf.javase.date;

import cn.hutool.core.date.BetweenFormatter;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.StrUtil;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by @author yyf on 2024/9/12.
 */
public class HutDemo {

  public static void main(String[] args) {
    LocalDate localDate = LocalDate.of(2024, 9, 11);
    String leftTime = getLeftTime(localDate);
    System.out.println(leftTime);
  }
  public static String getLeftTime(LocalDate evaluateEndTime) {
    if (evaluateEndTime == null) {
      return StrUtil.EMPTY;
    }
    DateTime d = DateUtil.offsetDay(DateUtil.parseDate(LocalDateTimeUtil.formatNormal(evaluateEndTime)), 1);
    return DateUtil.formatBetween(d, new Date(), BetweenFormatter.Level.MINUTE);
  }
}
