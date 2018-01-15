package org.yyf.javase.bit;

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
  }
}
