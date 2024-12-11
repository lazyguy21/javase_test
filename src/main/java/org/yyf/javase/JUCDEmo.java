package org.yyf.javase;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by @author yyf on 2024/10/26.
 */
public class JUCDEmo {

  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      int i = 1 / 0;
    });

    thread.setUncaughtExceptionHandler((Thread t , Throwable e) -> System.out.println("error"));
    thread.start();

//    TimeUnit.MINUTES.sleep(10L);
  }

}
