package org.yyf.javase.string;

import java.lang.reflect.Array;

/**
 * Created by @author yyf on 2024/7/22.
 */
public class LengthDemo {

  public static void main(String[] args) {
    String str = "你sd";
    System.out.println(str.length());
    byte[] bytes = str.getBytes();
    int length = Array.getLength(bytes);
    System.out.println(length);
  }

}
