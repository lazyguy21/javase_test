package org.yyf.javase.guava.time;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import org.junit.Test;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * Created by @author yyf on 2018/10/17.
 */
public class TestContainer {
  @Test
  public void t() throws InterruptedException {
    Stopwatch started = Stopwatch.createStarted();
    MILLISECONDS.sleep(1000L);
    long elapsed = started.elapsed(TimeUnit.MILLISECONDS);
    started.reset().start();
    MILLISECONDS.sleep(1500L);
    long elapsed1 = started.elapsed(TimeUnit.MILLISECONDS);
    System.out.println(elapsed);
    System.out.println(elapsed1);
  }
}
