package org.yyf.javase.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tobi on 2017/6/15.
 */
public class Bit {
  public static void main(String[] args) {
    //    return (this.flags & (1L << f.ordinal())) != 0;
    System.out.println(16512 & (1L << 1));
    System.out.println(32783 & (1L << 1));
    System.out.println(16512 & (1L << 1));
    System.out.println(16512 & (1L << 1));

    System.out.println(1 << 30);
    System.out.println(2);

    System.out.println(Integer.toBinaryString(31));
    Map<Integer, Integer> map = new HashMap<>();
    map.put(null, null);
    map.put(1, null);
    map.put(null, 1);
    map.put(null, 2);
    Integer i = map.get(null);
    System.out.println(i);
  }
}
