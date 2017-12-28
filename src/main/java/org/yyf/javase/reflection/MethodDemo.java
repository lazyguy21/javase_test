package org.yyf.javase.reflection;

import org.junit.Test;

import java.lang.reflect.Method;

public class MethodDemo {
  @Test
  public void demo1(){
    Method[] methods = MethodDemo.class.getMethods();
  }
}
