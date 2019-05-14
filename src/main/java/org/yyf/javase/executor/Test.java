package org.yyf.javase.executor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by @author yyf on 2019-04-30.
 */
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1, 2, 10000L, TimeUnit.SECONDS,
                new SynchronousQueue<>(),new ThreadPoolExecutor.AbortPolicy()
        );

        Runnable runnable = () -> {
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        pool.submit(runnable);
        pool.submit(runnable);
        pool.submit(runnable);



    }
}
