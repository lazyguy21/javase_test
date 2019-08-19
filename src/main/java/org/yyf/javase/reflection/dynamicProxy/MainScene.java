package org.yyf.javase.reflection.dynamicProxy;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by @author yyf on 2019-07-06.
 */
public class MainScene {

  public static void main(String[] args) {
    Target target = new TargetImpl();
    MyInvocationHandler invocationHandler = new MyInvocationHandler(target);
    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

    Target proxyInstance = (Target) Proxy.newProxyInstance(TargetImpl.class.getClassLoader(), new Class[]{Target.class},
        invocationHandler);
    proxyInstance.doSth();

    Class<? extends Target> aClass = proxyInstance.getClass();

    System.out.println(Arrays.toString(proxyInstance.getClass().getInterfaces()));

  }

}
