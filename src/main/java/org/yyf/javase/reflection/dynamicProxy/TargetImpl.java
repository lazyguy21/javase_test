package org.yyf.javase.reflection.dynamicProxy;

/**
 * Created by @author yyf on 2019-07-06.
 */
public class TargetImpl implements Target{

  @Override
  public void doSth() {
    System.out.println(this.getClass().getName() + " do sth mocking");
  }
}
