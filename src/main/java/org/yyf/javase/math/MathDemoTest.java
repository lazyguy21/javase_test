package org.yyf.javase.math;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by @author yyf on 2019-04-10.
 */
public class MathDemoTest {
    Double d = 123.9d;
    double d2 = -123.9d;
    double d3 = -123.1d;

    @Test
    public void floor() {
        double After = Math.floor(d);
        double After2 = Math.floor(d2);
        double After3 = Math.floor(d3);
        System.out.println(After);
        System.out.println(After2);
        System.out.println(After3);
    }
    @Test
    public void ceil() {
        double After = Math.ceil(d);
        double After2 = Math.ceil(d2);
        double After3 = Math.ceil(d3);
        System.out.println(After);
        System.out.println(After2);
        System.out.println(After3);
    }

    @Test
    public void round() {
        double After = Math.round(d);
        double After2 = Math.round(d2);
        double After3 = Math.round(d3);
        System.out.println(After);
        System.out.println(After2);
        System.out.println(After3);
    }

    @Test
    public void tetstCell() {
        BigDecimal bigDecimal = BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_CEILING);
        System.out.println(bigDecimal.compareTo(BigDecimal.ZERO)==0);
        System.out.println(Objects.equals(bigDecimal,BigDecimal.ZERO));
        System.out.println(bigDecimal.equals(BigDecimal.ZERO));
        System.out.println(bigDecimal);
    }
}