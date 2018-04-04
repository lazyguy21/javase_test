package org.yyf.javase.bit;

public class Shift {
  public static void main(String[] args) {
    int a = 0x01;
    int b = a << 4;
    System.out.println(a);
    System.out.println(b);


    System.out.println(1<<4);
    System.out.println(-1 << 4);
    System.out.println(Integer.toBinaryString(-1));
  }
}
