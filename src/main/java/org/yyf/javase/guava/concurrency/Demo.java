package org.yyf.javase.guava.concurrency;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

/**
 * Created by @author yyf on 2019-05-30.
 */
public class Demo {
    @Test
    public void t() {
        RateLimiter rateLimiter = RateLimiter.create(3);
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire(100));
        System.out.println(rateLimiter.acquire(10));
    }

    @Test
    public void test() {
//        RateLimiter.create()
    }
}
