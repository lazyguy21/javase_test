package org.yyf.javase.reflection;

import java.lang.reflect.Proxy;

/**
 * Created by @author yyf on 2019-06-23.
 */
public class MainScene {

    public static void main(String[] args) {
        ActionImpl target = new ActionImpl();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        ActionI proxy2 = (ActionI) Proxy.newProxyInstance(ActionI.class.getClassLoader(),interfaces, new ActionInvocationHandler(target));
        ActionI proxy = (ActionI) Proxy.newProxyInstance(ActionI.class.getClassLoader(),new Class[]{ ActionI.class}, new ActionInvocationHandler(target));
        proxy.doSth("haha");
    }
}
