package org.yyf.javase.baseType;

import java.math.BigDecimal;

public class BigDecimalTest {
  public static void main(String[] args) {
    BigDecimal a = new BigDecimal("10.001");
    BigDecimal b = new BigDecimal("100.101");
    System.out.println(a);
    System.out.println(b);
    BigDecimal result = a.subtract(b);
    System.out.println(result);

    BigDecimal r = a.add(result);
    System.out.println(r);
  }
}
