package org.yyf.javase.genericType;

import com.google.common.collect.Lists;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PCES {
  public static void main(String[] args) {
    List<? extends Fruit> foo3 = new ArrayList<Banana>();  // Number "extends" Number (in this context)
//    List<? extends Number> foo3 = new ArrayList<Integer>(); // Integer extends Number
//    List<? extends Number> foo3 = new ArrayList<Double>();  // Double extends Number
    Fruit item = foo3.get(0);

//    foo3.add();//这里你什么都放不进去，因为你不知道这个容器到底具体是放哪一种水果的。



    ArrayList<? super Banana> foo4 = new ArrayList<Banana>();
//    ArrayList<? super Banana> foo4 = new ArrayList<Fruit>();
//    ArrayList<? super Banana> foo4 = new ArrayList<Object>();
    foo4.add(new Banana());
//    foo4.add(new );

//    List<Number> numbers = new ArrayList<Integer>();不行

    List<? extends Number> list;
    list = new ArrayList<Number>();
    list = new ArrayList<Integer>();
    list = new ArrayList<Double>();

    List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
    List<Number> list2 = Lists.newArrayList(1, new Double(2), new Float(1.2), 4, 5, 6L);
    Collections.copy(list2,list);

    ArrayList<Integer> integers = new ArrayList<>();
    ArrayList<Double> doubles = new ArrayList<>();
    new ArrayList<Number>(integers);
    new ArrayList<Number>(doubles);

  }
}
