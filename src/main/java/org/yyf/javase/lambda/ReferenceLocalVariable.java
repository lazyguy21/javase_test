package org.yyf.javase.lambda;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created by tobi on 2017/6/28.
 */
public class ReferenceLocalVariable {
  static volatile Function<Integer, Integer> function;

  /**
   * 这个例子的本质是在说明lambda引用局部变量的本质就是copy了一份在自己的实例体内。
   * 相当于 Funciton(String[] name);
   * @param args
   * @throws InterruptedException
   */
  public static void main(String[] args) throws InterruptedException {
    new Thread(() -> {
      final String[] name = {"haha"};
      function = (Integer x) -> {
        System.out.println(name[0]);
        name[0] = "hahah";
        return x + 1;
      };
    }).start();
    TimeUnit.SECONDS.sleep(1L);
    new Thread(() -> {
      function.apply(1);
    }).start();
    TimeUnit.SECONDS.sleep(1L);
    TimeUnit.HOURS.sleep(1L);
  }
}
