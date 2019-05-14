package org.yyf.javase.lambda;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

/**
 * Created by @author yyf on 2018/10/30.
 */
public class AvgDemo {
  public static void main(String[] args) {
    List<Integer> list = Lists.newArrayList(1, 2, null);
    OptionalDouble average = list.stream().mapToInt(item->{
      return item;
    }).average();
    double asDouble = average.getAsDouble();
    System.out.println(asDouble);
  }
}
