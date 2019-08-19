package org.yyf.javase.reflection.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by @author yyf on 2019-07-06.
 */
public class MyInvocationHandler implements InvocationHandler {

  Target target;

  public MyInvocationHandler(Target target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//    Class<?>[] interfaces = proxy.getClass().getInterfaces();
//    System.out.println(Arrays.toString(args));
//
//    System.out.println("proxy is: " + proxy.getClass().getName());
//    System.out.println("method is: "+method.getName());
//    System.out.println("args: " + Arrays.toString(args));

    System.out.println("do sth before target's actual logic");
    try {
//      target.doSth();
      Object result = method.invoke(target, args);
      return result;
    } catch (Exception e) {
      System.out.println("doth if target throw ex");
      throw e;
    } finally {
      System.out.println("doth after all in finally block");
    }

  }

}
