package org.yyf.javase.net;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.LongAdder;

public class T {
  public static void main(String[] args) {
    LongAdder longAdder = new LongAdder();

    for (int i = 0; i < 10; i++) {
      UUID uuid = UUID.randomUUID();
      System.out.println(uuid);
      Date date = new Date();
      System.out.println(date);
      longAdder.increment();
      System.out.println(longAdder);
    }
    LongAdder longAdder1 = new LongAdder();
    longAdder1.add(Long.MAX_VALUE);
    System.out.println(longAdder1);
    longAdder.add(1L);

    System.out.println(longAdder1);


  }
}
