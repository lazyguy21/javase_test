package org.yyf.javase.baseType;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalTest {
    public static void main(String[] args) {
//        BigDecimal a = new BigDecimal("10.001");
//        BigDecimal b = new BigDecimal("100.101");
//        System.out.println(a);
//        System.out.println(b);
//        BigDecimal result = a.subtract(b);
//        System.out.println(result);
//
//        BigDecimal r = a.add(result);
//        System.out.println(r);


        int length = 15987244;
        long elapsed = 332L;
        long i = length / 1024;
        double l = i / elapsed;
        double l1 = l * 1000;
        long kb = length / 1024;

        Object c = length / 1024 / elapsed * 1000;
        System.out.println(c.toString());
//        System.out.println((length / 1024) / (elapsed / 1000));

        System.out.println(length/elapsed);
        BigDecimal a = new BigDecimal(length);
        BigDecimal b = new BigDecimal(elapsed);
        BigDecimal subtract = a.divide(b, MathContext.DECIMAL32);

        System.out.println(subtract);

        BigDecimal bigDecimal = new BigDecimal("12.238").setScale(2, RoundingMode.CEILING);
        System.out.println(bigDecimal);
    }
}
