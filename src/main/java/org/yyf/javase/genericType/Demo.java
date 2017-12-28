package org.yyf.javase.genericType;

import java.util.ArrayList;
import java.util.List;

public class Demo {
  public static void main(String[] args) {
    List<? extends Number> foo3 = new ArrayList<Number>();  // Number "extends" Number (in this context)
//    List<? extends Number> foo3 = new ArrayList<Integer>(); // Integer extends Number
//    List<? extends Number> foo3 = new ArrayList<Double>();  // Double extends Number
//    foo3.add(1);
    Number number = foo3.get(0);

    List<? super Integer> foo4 = new ArrayList<Integer>();  // Integer is a "superclass" of Integer (in this context)
//    List<? super Integer> foo4 = new ArrayList<Number>();   // Number is a superclass of Integer
//    List<? super Integer> foo4 = new ArrayList<Object>();   // Object is a superclass of Integer
    Object object = foo4.get(0);
    foo4.add(1);
    foo4.add(1);
  }
}
