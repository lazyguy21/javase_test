package org.yyf.javase.math;

import java.math.BigDecimal;

/**
 * Created by @author yyf on 2024/4/25.
 */
public class DecimalToStrDemo {

  public static void main(String[] args) {
    BigDecimal bigDecimal = new BigDecimal("0.1").setScale(4);
    String plainString = bigDecimal.multiply(new BigDecimal("100")).setScale(2).toPlainString();
    System.out.println(plainString);
  }

}
