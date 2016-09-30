package org.yyf.javase.util;

import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 16-9-26.
 */
public class TimeUnitTest {
    public static void main(String[] args) {
        long durationInSeconds = TimeUnit.SECONDS.convert(1L, TimeUnit.MINUTES);
        System.out.println(durationInSeconds);

        long l = System.nanoTime();
        System.out.println(l);

        long l2 = System.nanoTime();
        System.out.println(l2);
    }
}
