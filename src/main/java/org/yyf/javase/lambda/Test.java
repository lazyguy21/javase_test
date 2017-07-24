package org.yyf.javase.lambda;

import org.yyf.javase.domain.App;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yeyf on 2015-2-11.
 */
public class Test {
  public static void main(String[] args) {
//        new Thread(() -> System.out.println("cao")).start();
    List<Integer> integers = Arrays.asList(1, 2, 3, 4);
    boolean equals = Objects.equals(null, 1);
    System.out.println(equals);
//        integers.stream().colcollect(ArrayList::new, ArrayList::add, ArrayList::addAll);
  }

  @org.junit.Test
  public void t() {
    App app0 = new App(1L);
    App app1 = new App(2L);
    App app2 = new App(3L);
    App app3 = new App(4L);
//        List<App> integers = Arrays.asList(app0,app1,app2,app3);
    List<App> integers = Collections.EMPTY_LIST;
    Map<Long, App> map = integers.stream().map(item -> {
      System.out.println(item);
      return item;
    }).collect(Collectors.toMap(App::getId, p -> p));
    System.out.println(map);
  }

  /**
   * 根据predicate条件将stream、分到true和false分组的list中
   */
  @org.junit.Test
  public void t2() {
    Stream<Integer> integerStream = Stream.of(1, 2, 9, 4, 0, 5, 2, 1, -1, 8, 7);
    Map<Boolean, List<Integer>> map =
        integerStream.collect(Collectors.partitioningBy(item -> Integer.compare(item, 5) > -1));
    System.out.println(map);//{false=[1, 2, 4, 0, 2, 1, -1], true=[9, 5, 8, 7]}
  }

  @org.junit.Test
  public void t3() {
    Stream<Integer> integerStream = Stream.of(1, 2, 9, 4, 0, 5, 2, 1, -1, 8, 7);
    integerStream.map(item-> item.toString())
                 .collect(Collectors.joining("-", "[", "]"));


  }
}
