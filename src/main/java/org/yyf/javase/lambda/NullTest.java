package org.yyf.javase.lambda;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * Created by @author yyf on 2019/1/8.
 */
public class NullTest {
  public static void main(String[] args) {
    String format = String.format("%.3f", 0.445644444);
    System.out.println(format);
//    List<Integer> list = List.of(1, 2);
//    OptionalDouble average = list.stream().mapToInt(item -> {
//      System.out.println(item);
//      if (item == 2) {
//        return null;
//      }
//      return item;
//    }).average();
//    System.out.println(average.getAsDouble());
  }
}
