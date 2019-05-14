package org.yyf.javase.baseType;

import java.math.BigDecimal;

/**
 * Created by @author yyf on 2018/11/16.
 */
public class DecimalDemo {
  public static void main(String[] args) {
    Double a = 0.7d;
    BigDecimal bigDecimal = new BigDecimal(a);
    BigDecimal big = new BigDecimal(Double.toString(a));
    System.out.println(a);
    System.out.println(bigDecimal);
    System.out.println(big);
  }
}
